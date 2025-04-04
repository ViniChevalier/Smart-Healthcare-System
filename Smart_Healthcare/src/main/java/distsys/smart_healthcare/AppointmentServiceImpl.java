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

// Define Appointment model
class Appointment {
    private final String appointmentId;
    private final String patientId;
    private final String doctorId;
    private final String appointmentTime;

    public Appointment(String appointmentId, String patientId, String doctorId, String appointmentTime) {
        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.appointmentTime = appointmentTime;
    }

    public String getAppointmentId() { return appointmentId; }
    public String getPatientId() { return patientId; }
    public String getDoctorId() { return doctorId; }
    public String getAppointmentTime() { return appointmentTime; }
}

public class AppointmentServiceImpl extends AppointmentServiceImplBase {

    // Use an ArrayList to store appointments
    ArrayList<Appointment> appointments = new ArrayList<>();

public void bookAppointment(AppointmentRequest request, StreamObserver<AppointmentResponse> responseObserver) {
    String appointmentId = "APT-" + System.currentTimeMillis();

    // Create new Appointment object and add it to the list
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
            .setMessage("Appointment booked successfully!" +
                    "\nAppointment ID: " + appointmentId)
            .build();

    // Send response
    responseObserver.onNext(response);
    responseObserver.onCompleted();
}

@Override
public void getAppointment(AppointmentIdRequest request, StreamObserver<AppointmentResponse> responseObserver) {
    // Search for the appointment in the list
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

    // If not found, return an error message
    AppointmentResponse response = AppointmentResponse.newBuilder()
            .setMessage("Appointment not found!" +
                    "\nID: " + request.getAppointmentId())
            .setSuccess(false)
            .build();

    responseObserver.onNext(response);
    responseObserver.onCompleted();
}

    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(50051)
                .addService(new AppointmentServiceImpl())
                .build()
                .start();

        System.out.println("Appointment Service started on port 50051...");
        server.awaitTermination();
    }
}