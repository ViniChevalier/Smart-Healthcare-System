/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package distsys.smart_healthcare;

/**
 *
 *
 * @author vinicius
 */
class Appointment {

    private final String appointmentId;
    private final String patientId;
    private final String doctorId;
    private final String appointmentTime;

// constructor
    public Appointment(String appointmentId, String patientId, String doctorId, String appointmentTime) {
        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.appointmentTime = appointmentTime;
    }

    //Getters
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
