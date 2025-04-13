/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package distsys.smart_healthcare;

/**
 *
 *
 * Author: vinicius
 */
class Appointment {

    // Unique identifier for the appointment
    private final String appointmentId;

    // Identifier of the patient associated with the appointment
    private final String patientId;

    // Identifier of the doctor associated with the appointment
    private final String doctorId;

    // Time at which the appointment is scheduled
    private final String appointmentTime;

    // Constructor
    public Appointment(String appointmentId, String patientId, String doctorId, String appointmentTime) {
        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.appointmentTime = appointmentTime;
    }

    // Getters and Setters
    public String getAppointmentId() {
        return appointmentId;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }
}
