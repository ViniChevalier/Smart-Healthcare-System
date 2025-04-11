/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package distsys.smart_healthcare;

/**
 *
 * @author vinicius
 */
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

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

public class SmartHealthcareServer {

    static class AppointmentServiceImpl extends AppointmentServiceImplBase {

        // ArrayList to store appointments
        ArrayList<Appointment> appointments = new ArrayList<>();

        // ArrayList to store doctors
        ArrayList<Doctor> doctors = new ArrayList<>();

        // Counter for the appointments
        private static int appointmentCounter = 1;

        // Method to create appointment
        @Override
        public void scheduleAppointment(AppointmentRequest request, StreamObserver<AppointmentResponse> responseObserver) {
            String appointmentId = "APPT-" + appointmentCounter++;

            // Create new Appointment object and add it
            Appointment appointment = new Appointment(
                    appointmentId,
                    request.getPatientId(),
                    request.getDoctorId(),
                    request.getDateTime()
            );
            appointments.add(appointment);

            // Build response with the fields defined in the proto file
            AppointmentResponse response = AppointmentResponse.newBuilder()
                    .setSuccess(true)
                    .setMessage("Appointment booked successfully!"
                            + "\nAppointment ID: " + appointmentId)
                    .build();

            // Send response
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }

        // Method to obtain the appointment 
        @Override
        public void getAppointment(AppointmentIdRequest request, StreamObserver<AppointmentResponse> responseObserver) {

            // Search for the appointment
            for (Appointment appointment : appointments) {
                if (appointment.getAppointmentId().equals(request.getAppointmentId())) {
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

            // If not found
            AppointmentResponse response = AppointmentResponse.newBuilder()
                    .setMessage("Appointment not found!"
                            + "\nID: " + request.getAppointmentId())
                    .setSuccess(false)
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }

        // Method to add a doctor
        @Override
        public void addDoctor(AddDoctorRequest request, StreamObserver<AddDoctorResponse> responseObserver) {
            String doctorId = request.getDoctorId();

            // Add the doctor
            doctors.add(new Doctor(doctorId));

            // Build the response
            AddDoctorResponse response = AddDoctorResponse.newBuilder()
                    .setSuccess(true)
                    .setMessage("Doctor added successfully.")
                    .setDoctorId(doctorId)
                    .build();

            // Return the response
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }

        // Method to add availability for a doctor
        @Override
        public void addAvailability(AddAvailabilityRequest request, StreamObserver<AddAvailabilityResponse> responseObserver) {
            String doctorId = request.getDoctorId();
            String timeSlot = request.getTimeSlot();

            boolean doctorFound = false;
            for (Doctor doctor : doctors) {
                if (doctor.getDoctorId().equals(doctorId)) {
                    doctor.addAvailability(timeSlot);
                    doctorFound = true;
                    break;
                }
            }

            AddAvailabilityResponse response = AddAvailabilityResponse.newBuilder()
                    .setSuccess(doctorFound)
                    .setMessage(doctorFound ? "Availability added." : "Doctor not found.")
                    .setDoctorId(doctorId)
                    .setTimeSlot(timeSlot)
                    .build();

            if (!doctorFound) {
                System.out.println("Doctor not found: " + doctorId);
            }

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }

        // Method to obtain availability of the doctor
        @Override
        public void getAvailability(AvailabilityRequest request, StreamObserver<AvailabilityResponse> responseObserver) {
            String doctorId = request.getDoctorId();
            boolean doctorFound = false;

            for (Doctor doctor : doctors) {
                if (doctor.getDoctorId().equals(doctorId)) {
                    doctorFound = true;
                    List<String> availableSlots = doctor.getAvailableSlots();

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

            if (!doctorFound) {
                System.out.println("Doctor not found: " + doctorId);
            }

            responseObserver.onCompleted();
        }

    }

    static class TelemedicineServiceImpl extends TelemedicineServiceImplBase {

        private final List<StreamObserver<MessageResponse>> connectedClients = new CopyOnWriteArrayList<>();

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

        @Override
        public StreamObserver<MessageRequest> chat(StreamObserver<MessageResponse> responseObserver) {
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
                    connectedClients.remove(responseObserver);
                }

                @Override
                public void onCompleted() {
                    connectedClients.remove(responseObserver);
                    responseObserver.onCompleted();
                }

            };
        }
    }

    static class HealthMonitoringServiceImpl extends HealthMonitoringServiceImplBase {

        @Override
        public StreamObserver<HealthDataRequest> sendHealthData(StreamObserver<HealthDataResponse> responseObserver) {
            return new StreamObserver<>() {
                List<HealthDataRequest> receivedData = new ArrayList<>();

                @Override
                public void onNext(HealthDataRequest value) {
                    System.out.println("Received health data from: " + value.getDeviceId());
                    receivedData.add(value);
                }

                @Override
                public void onError(Throwable t) {
                    System.err.println("Health data stream error: " + t.getMessage());
                }

                @Override
                public void onCompleted() {
                    // Calculate the average heart rate and temperature
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

                        // Calculate the averages
                        float avgHeartRate = (float) totalHeartRate / receivedData.size();
                        float avgTemperature = totalTemperature / receivedData.size();

                        // Prepare the response message
                        String message = "Received health data entries. Average Heart Rate: " + avgHeartRate + " Average Temperature: " + avgTemperature;

                        HealthDataResponse response = HealthDataResponse.newBuilder()
                                .setMessage(message)
                                .build();

                        responseObserver.onNext(response);
                    }

                    // Complete the stream
                    responseObserver.onCompleted();
                }
            };
        }

        @Override
        public StreamObserver<EmergencyAlertRequest> alertEmergency(StreamObserver<EmergencyAlertResponse> responseObserver) {
            ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

            return new StreamObserver<>() {

                @Override
                public void onNext(EmergencyAlertRequest alert) {
                    // Log the incoming alert
                    System.out.println("Received Emergency Alert:");
                    System.out.println("- Patient ID: " + alert.getPatientId());
                    System.out.println("- Type: " + alert.getAlertType());
                    System.out.println("- Message: " + alert.getAlertMessage());

                    // Immediate response acknowledging receipt
                    EmergencyAlertResponse ack = EmergencyAlertResponse.newBuilder()
                            .setConfirmation("Alert received and acknowledged for patient: " + alert.getPatientId())
                            .build();
                    responseObserver.onNext(ack);

                    // Schedule a delayed instruction after 30 seconds
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
                    System.err.println("Emergency alert stream error: " + t.getMessage());
                    t.printStackTrace();
                }

                @Override
                public void onCompleted() {
                    System.out.println("Emergency alert stream completed.");
                    responseObserver.onCompleted();
                    scheduler.shutdown(); // Optional: shut down when done
                }

                // Generate custom instruction message based on alert type
                private String generateInstructions(String alertType) {
                    switch (alertType.toLowerCase()) {
                        case "heart":
                            return "Please monitor the patient's heart rate closely and prepare for possible ECG.";
                        case "temperature":
                            return "Ensure the patient is hydrated and adjust room temperature. Contact a doctor if condition worsens.";
                        case "fall":
                            return "Check for physical injuries and avoid moving the patient until help arrives.";
                        case "all":
                            return "Full medical assessment is recommended. Notify emergency medical services immediately.";
                        default:
                            return "Follow standard emergency procedures and notify healthcare staff.";
                    }
                }
            };
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(50051)
                .addService(new AppointmentServiceImpl())
                .addService(new TelemedicineServiceImpl())
                .addService(new HealthMonitoringServiceImpl())
                .build()
                .start();

        System.out.println("Healthcare Service started on port 50051...");
        server.awaitTermination();
    }

}
