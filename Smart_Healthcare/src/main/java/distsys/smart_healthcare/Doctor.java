/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package distsys.smart_healthcare;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 * Author: vinicius
 */
class Doctor {

    // Unique identifier for the doctor
    private String doctorId;

    // List of available time slots for appointments
    private List<String> availableSlots;

    // Constructor
    public Doctor(String doctorId) {
        this.doctorId = doctorId;
        this.availableSlots = new ArrayList<>();
    }

    // Getters and Setters
    public String getDoctorId() {
        return doctorId;
    }

    public List<String> getAvailableSlots() {
        return availableSlots;
    }

    public void addAvailability(String slot) {
        availableSlots.add(slot);
    }

    public void removeAvailability(String timeSlot) {
        availableSlots.remove(timeSlot);
    }

}
