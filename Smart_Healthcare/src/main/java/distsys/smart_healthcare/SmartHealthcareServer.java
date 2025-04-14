/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package distsys.smart_healthcare;

/**
 *
 * @author vinicius
 */
import io.grpc.*;
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
import distsys.smart_healthcare.Auth.AuthorizationServerInterceptor;
import distsys.smart_healthcare.Auth.Constants;
import io.grpc.ServerCall.Listener;
import io.grpc.ServerInterceptor;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SmartHealthcareServer {

    // Metadata
    private static final Logger logger = Logger.getLogger(SmartHealthcareServer.class.getName());

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
            // Auth  
            String clientId = Constants.CLIENT_ID_CONTEXT_KEY.get();
            logger.info("Processing scheduleAppointment request from " + clientId);

            String doctorId = request.getDoctorId();
            String timeSlot = request.getDateTime();

            // Find the doctor
            Doctor foundDoctor = null;
            for (Doctor doctor : doctors) {
                if (doctor.getDoctorId().equals(doctorId)) {
                    foundDoctor = doctor;
                    break;
                }
            }

            if (foundDoctor == null) {
                AppointmentResponse response = AppointmentResponse.newBuilder()
                        .setSuccess(false)
                        .setMessage("Error: Doctor with ID '" + doctorId + "' not found.")
                        .build();

                responseObserver.onNext(response);
                responseObserver.onCompleted();
                return;
            }

            // Check if the requested time slot is available
            if (!foundDoctor.getAvailableSlots().contains(timeSlot)) {
                AppointmentResponse response = AppointmentResponse.newBuilder()
                        .setSuccess(false)
                        .setMessage("Error: Requested time slot '" + timeSlot + "' is not available for Doctor " + doctorId)
                        .build();

                responseObserver.onNext(response);
                responseObserver.onCompleted();
                return;
            }

            // Create unique ID
            String appointmentId = "APPT-" + appointmentCounter++;

            // Create and store the appointment object
            Appointment appointment = new Appointment(
                    appointmentId,
                    request.getPatientId(),
                    doctorId,
                    timeSlot
            );
            appointments.add(appointment);

            // Remove the booked time slot from availability
            foundDoctor.removeAvailability(timeSlot);

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
            // Auth  
            String clientId = Constants.CLIENT_ID_CONTEXT_KEY.get();
            logger.info("Processing scheduleAppointment request from " + clientId);

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
            // Auth  
            String clientId = Constants.CLIENT_ID_CONTEXT_KEY.get();
            logger.info("Processing scheduleAppointment request from " + clientId);

            String doctorId = request.getDoctorId();

            // Check for duplicate doctor ID
            for (Doctor doctor : doctors) {
                if (doctor.getDoctorId().equals(doctorId)) {
                    AddDoctorResponse response = AddDoctorResponse.newBuilder()
                            .setSuccess(false)
                            .setMessage("Error: Doctor with ID '" + doctorId + "' already exists.")
                            .setDoctorId(doctorId)
                            .build();

                    responseObserver.onNext(response);
                    responseObserver.onCompleted();
                    return;
                }
            }

            // Add the doctor
            doctors.add(new Doctor(doctorId));

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
            // Auth  
            String clientId = Constants.CLIENT_ID_CONTEXT_KEY.get();
            logger.info("Processing scheduleAppointment request from " + clientId);

            String doctorId = request.getDoctorId();
            String timeSlot = request.getTimeSlot();

            // Check if doctor exists
            Doctor foundDoctor = null;
            for (Doctor doctor : doctors) {
                if (doctor.getDoctorId().equals(doctorId)) {
                    foundDoctor = doctor;
                    break;
                }
            }

            AddAvailabilityResponse response;

            if (foundDoctor != null) {
                // Add availability
                foundDoctor.addAvailability(timeSlot);
                response = AddAvailabilityResponse.newBuilder()
                        .setSuccess(true)
                        .setMessage("Availability added.")
                        .setDoctorId(doctorId)
                        .setTimeSlot(timeSlot)
                        .build();
            } else {
                // Doctor not found
                System.out.println("Doctor not found: " + doctorId);
                response = AddAvailabilityResponse.newBuilder()
                        .setSuccess(false)
                        .setMessage("Error: Doctor with ID '" + doctorId + "' not found.")
                        .setDoctorId(doctorId)
                        .setTimeSlot(timeSlot)
                        .build();
            }

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }

        // Method to get the availability of a specific doctor
        @Override
        public void getAvailability(AvailabilityRequest request, StreamObserver<AvailabilityResponse> responseObserver) {
            // Auth  
            String clientId = Constants.CLIENT_ID_CONTEXT_KEY.get();
            logger.info("Processing scheduleAppointment request from " + clientId);

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
            // Auth  
            String clientId = Constants.CLIENT_ID_CONTEXT_KEY.get();
            logger.info("Processing scheduleAppointment request from " + clientId);

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
            // Auth  
            String clientId = Constants.CLIENT_ID_CONTEXT_KEY.get();
            logger.info("Processing scheduleAppointment request from " + clientId);

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
            // Auth  
            String clientId = Constants.CLIENT_ID_CONTEXT_KEY.get();
            logger.info("Processing scheduleAppointment request from " + clientId);

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
            // Auth  
            String clientId = Constants.CLIENT_ID_CONTEXT_KEY.get();
            System.out.println("Processing request from " + clientId);

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
        // Create a gRPC server

        int port = 50051;

        Server server = ServerBuilder.forPort(port)
                .addService(ServerInterceptors.intercept(new AppointmentServiceImpl(), new AuthorizationServerInterceptor()))
                .addService(ServerInterceptors.intercept(new TelemedicineServiceImpl(), new AuthorizationServerInterceptor()))
                .addService(ServerInterceptors.intercept(new HealthMonitoringServiceImpl(), new AuthorizationServerInterceptor()))
                .build();

        // Start the server
        server.start();
        logger.log(Level.INFO, "Server started, listening on {0}", port);
        System.out.println("Healthcare Server started, listening on " + port);

        // Add a shutdown hook for graceful shutdown
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            logger.info("Shutting down...");
            server.shutdown();
        }));

        // Block the main thread so the server keeps running
        server.awaitTermination();
    }
}
