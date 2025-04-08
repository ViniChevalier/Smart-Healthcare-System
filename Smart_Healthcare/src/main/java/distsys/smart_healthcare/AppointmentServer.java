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
import java.util.ArrayList;

import generated.grpc.AppointmentService.AppointmentServiceGrpc.AppointmentServiceImplBase;
import generated.grpc.AppointmentService.*;
import java.util.List;

public class AppointmentServer extends AppointmentServiceImplBase {

    // ArrayList to store appointments
    ArrayList<Appointment> appointments = new ArrayList<>();

    // ArrayList to store doctors
    ArrayList<Doctor> doctors = new ArrayList<>();

    // Counter for the appointments
    private static int appointmentCounter = 1;

    // Method to create appointment
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

    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(50051)
                .addService(new AppointmentServer())
                .build()
                .start();

        System.out.println("Appointment Service started on port 50051...");
        server.awaitTermination();
    }
}
