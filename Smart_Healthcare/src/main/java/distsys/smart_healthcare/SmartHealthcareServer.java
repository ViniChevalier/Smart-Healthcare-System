/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package distsys.smart_healthcare;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import io.grpc.ServerInterceptors;


import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import generated.grpc.AppointmentService.AppointmentServiceGrpc.AppointmentServiceImplBase;
import generated.grpc.AppointmentService.*;
import generated.grpc.TelemedicineService.TelemedicineServiceGrpc.TelemedicineServiceImplBase;
import generated.grpc.TelemedicineService.*;
import generated.grpc.HealthMonitoringService.HealthMonitoringServiceGrpc.HealthMonitoringServiceImplBase;
import generated.grpc.HealthMonitoringService.*;

/**
 *
 * @author vinicius
 */

public class SmartHealthcareServer {

    // Appointment service implementation
    static class AppointmentServiceImpl extends AppointmentServiceImplBase {

        // List to store appointment data
        ArrayList<Appointment> appointments = new ArrayList<>();

        // List to store doctor information
        ArrayList<Doctor> doctors = new ArrayList<>();

        // Counter to generate unique appointment IDs
        private static int appointmentCounter = 1;

        // Method to schedule a new appointment
        @Override
        public void scheduleAppointment(AppointmentRequest request, StreamObserver<AppointmentResponse> responseObserver) {
            String appointmentId = "APPT-" + appointmentCounter++;  // Create unique ID

            // Create and store the appointment object
            Appointment appointment = new Appointment(
                    appointmentId,
                    request.getPatientId(),
                    request.getDoctorId(),
                    request.getDateTime()
            );
            appointments.add(appointment);  // Add to the appointment list

            // Create a response message indicating success
            AppointmentResponse response = AppointmentResponse.newBuilder()
                    .setSuccess(true)
                    .setMessage("Appointment booked successfully!"
                            + "\nAppointment ID: " + appointmentId)
                    .build();

            // Send the response to the client
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }

        // Method to get an appointment based on ID
        @Override
        public void getAppointment(AppointmentIdRequest request, StreamObserver<AppointmentResponse> responseObserver) {
            // Search for the appointment with the requested ID
            for (Appointment appointment : appointments) {
                if (appointment.getAppointmentId().equals(request.getAppointmentId())) {
                    // If found, build and send a success response
                    AppointmentResponse response = AppointmentResponse.newBuilder()
                            .setMessage("Appointment found:"
                                    + "\nAppointment ID: " + appointment.getAppointmentId()
                                    + "\nPatient ID: " + appointment.getPatientId()
                                    + "\nDoctor ID: " + appointment.getDoctorId()
                                    + "\nDate & Time: " + appointment.getAppointmentTime())
                            .setSuccess(true)
                            .build();

                    responseObserver.onNext(response);
                    responseObserver.onCompleted();
                    return;
                }
            }

            // If appointment is not found, send failure response
            AppointmentResponse response = AppointmentResponse.newBuilder()
                    .setMessage("Appointment not found!"
                            + "\nID: " + request.getAppointmentId())
                    .setSuccess(false)
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }

        // Method to add a new doctor
        @Override
        public void addDoctor(AddDoctorRequest request, StreamObserver<AddDoctorResponse> responseObserver) {
            String doctorId = request.getDoctorId();

            // Add the doctor to the list
            doctors.add(new Doctor(doctorId));

            // Create a response indicating success
            AddDoctorResponse response = AddDoctorResponse.newBuilder()
                    .setSuccess(true)
                    .setMessage("Doctor added successfully.")
                    .setDoctorId(doctorId)
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }

        // Method to add availability for a specific doctor
        @Override
        public void addAvailability(AddAvailabilityRequest request, StreamObserver<AddAvailabilityResponse> responseObserver) {
            String doctorId = request.getDoctorId();
            String timeSlot = request.getTimeSlot();

            boolean doctorFound = false;
            // Check if the doctor exists in the list
            for (Doctor doctor : doctors) {
                if (doctor.getDoctorId().equals(doctorId)) {
                    // Add the availability if doctor is found
                    doctor.addAvailability(timeSlot);
                    doctorFound = true;
                    break;
                }
            }

            // Build response based on whether doctor was found
            AddAvailabilityResponse response = AddAvailabilityResponse.newBuilder()
                    .setSuccess(doctorFound)
                    .setMessage(doctorFound ? "Availability added." : "Doctor not found.")
                    .setDoctorId(doctorId)
                    .setTimeSlot(timeSlot)
                    .build();

            // Log if doctor was not found
            if (!doctorFound) {
                System.out.println("Doctor not found: " + doctorId);
            }

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }

        // Method to get the availability of a specific doctor
        @Override
        public void getAvailability(AvailabilityRequest request, StreamObserver<AvailabilityResponse> responseObserver) {
            String doctorId = request.getDoctorId();
            boolean doctorFound = false;

            // Search for the doctor and get available time slots
            for (Doctor doctor : doctors) {
                if (doctor.getDoctorId().equals(doctorId)) {
                    doctorFound = true;
                    List<String> availableSlots = doctor.getAvailableSlots();

                    // Send available time slots as response
                    for (String slot : availableSlots) {
                        if (slot != null && !slot.isEmpty()) {
                            AvailabilityResponse response = AvailabilityResponse.newBuilder()
                                    .setDateTime(slot)
                                    .build();
                            responseObserver.onNext(response);
                        }
                    }
                    break;
                }
            }

            // Log if doctor was not found
            if (!doctorFound) {
                System.out.println("Doctor not found: " + doctorId);
            }

            responseObserver.onCompleted();
        }
    }

    // Telemedicine service implementation
    static class TelemedicineServiceImpl extends TelemedicineServiceImplBase {

        // List of connected clients for broadcasting chat messages
        private final List<StreamObserver<MessageResponse>> connectedClients = new CopyOnWriteArrayList<>();

        // Method to start a telemedicine consultation
        @Override
        public void startConsultation(ConsultationRequest request, StreamObserver<ConsultationResponse> responseObserver) {
            String patientId = request.getPatientId();
            String doctorId = request.getDoctorId();

            System.out.println("Starting consultation between Patient " + patientId + " and Doctor " + doctorId);

            ConsultationResponse response = ConsultationResponse.newBuilder()
                    .setSuccess(true)
                    .setMessage("Consultation started")
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }

        // Method to handle chat between patients and doctors
        @Override
        public StreamObserver<MessageRequest> chat(StreamObserver<MessageResponse> responseObserver) {
            // Add the client to the list of connected clients
            connectedClients.add(responseObserver);

            return new StreamObserver<MessageRequest>() {
                @Override
                public void onNext(MessageRequest value) {
                    // Broadcast the message to all connected clients
                    for (StreamObserver<MessageResponse> client : connectedClients) {
                        client.onNext(MessageResponse.newBuilder()
                                .setSender(value.getSender())
                                .setMessageText(value.getMessageText())
                                .build());
                    }
                }

                @Override
                public void onError(Throwable t) {
                    // Remove the client if there is an error
                    connectedClients.remove(responseObserver);
                }

                @Override
                public void onCompleted() {
                    // Remove the client when the stream is completed
                    connectedClients.remove(responseObserver);
                    responseObserver.onCompleted();
                }
            };
        }
    }

    // Health monitoring service implementation
    static class HealthMonitoringServiceImpl extends HealthMonitoringServiceImplBase {

        // Method to handle incoming health data
        @Override
        public StreamObserver<HealthDataRequest> sendHealthData(StreamObserver<HealthDataResponse> responseObserver) {
            return new StreamObserver<>() {
                List<HealthDataRequest> receivedData = new ArrayList<>();

                @Override
                public void onNext(HealthDataRequest value) {
                    // Log the received health data
                    System.out.println("Received health data from: " + value.getDeviceId());
                    receivedData.add(value);
                }

                @Override
                public void onError(Throwable t) {
                    // Log error if health data stream has an issue
                    System.err.println("Health data stream error: " + t.getMessage());
                }

                @Override
                public void onCompleted() {
                    // Process the health data and calculate averages
                    if (receivedData.isEmpty()) {
                        responseObserver.onNext(HealthDataResponse.newBuilder()
                                .setMessage("No data received.")
                                .build());
                    } else {
                        int totalHeartRate = 0;
                        float totalTemperature = 0.0f;

                        for (HealthDataRequest data : receivedData) {
                            totalHeartRate += data.getHeartRate();
                            totalTemperature += data.getTemperature();
                        }

                        // Calculate the averages for heart rate and temperature
                        float avgHeartRate = (float) totalHeartRate / receivedData.size();
                        float avgTemperature = totalTemperature / receivedData.size();

                        // Prepare the response message
                        String message = "Received health data entries. Average Heart Rate: " + avgHeartRate + " Average Temperature: " + avgTemperature;

                        HealthDataResponse response = HealthDataResponse.newBuilder()
                                .setMessage(message)
                                .build();

                        responseObserver.onNext(response);
                    }

                    responseObserver.onCompleted();  // End the stream
                }
            };
        }

        // Method to handle emergency alert stream
        @Override
        public StreamObserver<EmergencyAlertRequest> alertEmergency(StreamObserver<EmergencyAlertResponse> responseObserver) {
            // Executor for scheduling follow-up tasks
            ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

            return new StreamObserver<>() {
                @Override
                public void onNext(EmergencyAlertRequest alert) {
                    // Log incoming alert details
                    System.out.println("Received Emergency Alert:");
                    System.out.println("- Patient ID: " + alert.getPatientId());
                    System.out.println("- Type: " + alert.getAlertType());
                    System.out.println("- Message: " + alert.getAlertMessage());

                    // Send immediate acknowledgement
                    EmergencyAlertResponse ack = EmergencyAlertResponse.newBuilder()
                            .setConfirmation("Alert received and acknowledged for patient: " + alert.getPatientId())
                            .build();
                    responseObserver.onNext(ack);

                    // Schedule follow-up instructions after 30 seconds
                    scheduler.schedule(() -> {
                        String instructions = generateInstructions(alert.getAlertType());
                        EmergencyAlertResponse followUp = EmergencyAlertResponse.newBuilder()
                                .setConfirmation("Follow-up for patient " + alert.getPatientId() + ": " + instructions)
                                .build();
                        responseObserver.onNext(followUp);
                    }, 30, TimeUnit.SECONDS);
                }

                @Override
                public void onError(Throwable t) {
                    // Log error if the emergency alert stream fails
                    System.err.println("Emergency alert stream error: " + t.getMessage());
                }

                @Override
                public void onCompleted() {
                    // Log when the stream is completed
                    System.out.println("Emergency alert stream completed.");
                    responseObserver.onCompleted();
                    scheduler.shutdown();  // Shut down the scheduler
                }

                // Helper method to generate instructions based on alert type
                private String generateInstructions(String alertType) {
                    switch (alertType.toLowerCase()) {
                        case "heart":
                            return "Please monitor the patient's heart rate closely and prepare for possible ECG.";
                        case "temperature":
                            return "Ensure the patient is hydrated and adjust room temperature. Contact a doctor if condition worsens.";
                        case "fall":
                            return "Check for physical injuries and avoid moving the patient until help arrives.";
                        default:
                            return "Follow standard emergency procedures and notify healthcare staff.";
                    }
                }
            };
        }
    }

    // Main method to start the healthcare server
    public static void main(String[] args) throws IOException, InterruptedException {
        // Set up the gRPC server to listen on port 50051 and add services
        Server server = ServerBuilder.forPort(50051)
                .addService(new AuthServiceImpl())
                .addService(ServerInterceptors.intercept(new AppointmentServiceImpl(), new AuthInterceptor())) // Add Appointment Service
                .addService(ServerInterceptors.intercept(new TelemedicineServiceImpl(), new AuthInterceptor())) // Add Telemedicine Service
                .addService(ServerInterceptors.intercept(new HealthMonitoringServiceImpl(), new AuthInterceptor())) // Add Health Monitoring Service
                .build()
                .start();

        System.out.println("Healthcare Service started on port 50051...");
        server.awaitTermination();
    }
}
