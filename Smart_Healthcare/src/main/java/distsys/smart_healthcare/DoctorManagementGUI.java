/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package distsys.smart_healthcare;

import generated.grpc.AppointmentService.AppointmentServiceGrpc;
import generated.grpc.AppointmentService.*;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author vinicius
 */
public class DoctorManagementGUI extends javax.swing.JFrame {

    private ManagedChannel channel;
    private AppointmentServiceGrpc.AppointmentServiceStub appointmentServiceClient;

    /**
     * Creates new form DoctorManagementGUI
     */
    public DoctorManagementGUI() {
        initComponents();

        // Initialize the gRPC connection
        channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();

        // Initialize the client
        appointmentServiceClient = AppointmentServiceGrpc.newStub(channel);

        // Action listener for Add Doctor button
        btnAddDoctor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addDoctor();
            }
        });

        // Action listener for Add Availability button
        btnAddAvailability.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addAvailability();
            }
        });

        // Action listener for Get Availability button
        btnGetAvailability.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getAvailability();
            }
        });
    }

    // Add Doctor method
    private void addDoctor() {
        String doctorName = txtDoctorName.getText();

        // Check if doctor name is not empty
        if (doctorName.isEmpty()) {
            txtAreaStatus.setText("Doctor name is required.");
            return;
        }

        try {
            appointmentServiceClient.addDoctor(AddDoctorRequest.newBuilder()
                    .setDoctorId(doctorName)
                    .build(), new StreamObserver<AddDoctorResponse>() {
                @Override
                public void onNext(AddDoctorResponse response) {
                }

                @Override
                public void onError(Throwable t) {
                    txtAreaStatus.setText("Error adding doctor: " + t.getMessage());
                }

                @Override
                public void onCompleted() {
                    txtAreaStatus.setText("Doctor added successfully.");
                    txtDoctorName.setText("");
                }
            });
        } catch (StatusRuntimeException e) {
            txtAreaStatus.setText("Error adding doctor: " + e.getStatus().getDescription());
        }
    }

    // Add Availability method
    private void addAvailability() {
        String doctorId = txtDoctorName1.getText();
        String timeSlot = txtAvailabilityTime.getText();

        // Check if time slot is not empty
        if (doctorId.isEmpty() || timeSlot.isEmpty()) {
            txtAreaStatus.setText("Both doctor ID and availability slot are required.");
            return;
        }

        try {
            appointmentServiceClient.addAvailability(AddAvailabilityRequest.newBuilder()
                    .setDoctorId(doctorId)
                    .setTimeSlot(timeSlot)
                    .build(), new StreamObserver<AddAvailabilityResponse>() {
                @Override
                public void onNext(AddAvailabilityResponse response) {

                }

                @Override
                public void onError(Throwable t) {
                    txtAreaStatus.setText("Error adding availability: " + t.getMessage());
                }

                @Override
                public void onCompleted() {
                    txtAreaStatus.setText("Availability added successfully.");
                    txtDoctorName1.setText("");  // Clear text fields after adding availability
                }
            });
        } catch (StatusRuntimeException e) {
            txtAreaStatus.setText("Error adding availability: " + e.getStatus().getDescription());
        }
    }

    // Get Availability method (Streaming)
    private void getAvailability() {
        String doctorId = txtDoctorName2.getText();

        if (doctorId.isEmpty()) {
            txtAreaStatus.setText("Doctor ID is required.");
            return;
        }

        AvailabilityRequest request = AvailabilityRequest.newBuilder()
                .setDoctorId(doctorId)
                .build();

        appointmentServiceClient.getAvailability(
                request,
                new StreamObserver<AvailabilityResponse>() {
            @Override
            public void onNext(AvailabilityResponse value) {
                String current = txtAreaStatus.getText();
                txtAreaStatus.setText(current + "\nAvailable slot: " + value.getDateTime());
            }

            @Override
            public void onError(Throwable t) {
                txtAreaStatus.setText("Error: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                String current = txtAreaStatus.getText();
                txtAreaStatus.setText(current + "\nAvailability streaming completed.");
            }
        }
        );
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtDoctorName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtDoctorName1 = new javax.swing.JTextField();
        txtAvailabilityTime = new javax.swing.JTextField();
        btnAddDoctor = new javax.swing.JButton();
        btnAddAvailability = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtDoctorName2 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAreaStatus = new javax.swing.JTextArea();
        btnGetAvailability = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Doctor ID");

        txtDoctorName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDoctorNameActionPerformed(evt);
            }
        });

        jLabel2.setText("Availability Slot");

        jLabel3.setText("Doctor ID");

        txtDoctorName1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDoctorName1ActionPerformed(evt);
            }
        });

        txtAvailabilityTime.setText("2025-04-04 14:00");

        btnAddDoctor.setText("Add a doctor");

        btnAddAvailability.setText("Add an availability slot");

        jLabel4.setText("Doctor ID");

        txtDoctorName2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDoctorName2ActionPerformed(evt);
            }
        });

        txtAreaStatus.setColumns(20);
        txtAreaStatus.setRows(5);
        jScrollPane2.setViewportView(txtAreaStatus);

        btnGetAvailability.setText("Retrieve availability slots");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Add Doctor");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Add an Availability");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Check Slots Avalable");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGetAvailability, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAddAvailability, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAddDoctor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(53, 53, 53)
                        .addComponent(txtDoctorName1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtAvailabilityTime))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(53, 53, 53)
                        .addComponent(txtDoctorName))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(54, 54, 54)
                        .addComponent(txtDoctorName2))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtDoctorName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAddDoctor)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDoctorName1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtAvailabilityTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAddAvailability)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDoctorName2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGetAvailability)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDoctorName1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDoctorName1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDoctorName1ActionPerformed

    private void txtDoctorNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDoctorNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDoctorNameActionPerformed

    private void txtDoctorName2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDoctorName2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDoctorName2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DoctorManagementGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DoctorManagementGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DoctorManagementGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DoctorManagementGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DoctorManagementGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddAvailability;
    private javax.swing.JButton btnAddDoctor;
    private javax.swing.JButton btnGetAvailability;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea txtAreaStatus;
    private javax.swing.JTextField txtAvailabilityTime;
    private javax.swing.JTextField txtDoctorName;
    private javax.swing.JTextField txtDoctorName1;
    private javax.swing.JTextField txtDoctorName2;
    // End of variables declaration//GEN-END:variables
}
