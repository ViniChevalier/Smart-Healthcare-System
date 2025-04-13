/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package distsys.smart_healthcare;

/**
 *
 * @author vinicius
 */
<<<<<<< HEAD
import auth.AuthServiceGrpc;
import auth.AuthServiceOuterClass.LoginRequest;
import auth.AuthServiceOuterClass.LoginResponse;
=======

>>>>>>> parent of fe9b6ec (Improvement on server)
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Iterator;

import generated.grpc.AppointmentService.AppointmentServiceGrpc;
import generated.grpc.AppointmentService.AppointmentRequest;
import generated.grpc.AppointmentService.AppointmentResponse;
import generated.grpc.AppointmentService.AppointmentIdRequest;
import generated.grpc.AppointmentService.AvailabilityRequest;
import generated.grpc.AppointmentService.AvailabilityResponse;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Metadata;
import io.grpc.stub.MetadataUtils;

public class AppointmentGUI extends javax.swing.JFrame {

<<<<<<< HEAD
    // gRPC channel and stub to connect to the AppointmentService
    private AppointmentServiceGrpc.AppointmentServiceBlockingStub appointmentStub;
=======
    private ManagedChannel channel;
    private AppointmentServiceGrpc.AppointmentServiceBlockingStub blockingStub;
>>>>>>> parent of fe9b6ec (Improvement on server)

    /**
     * Creates new form AppointmentClientGUI
     */
    // Constructor
// Constructor
    // Constructor
    public AppointmentGUI() {
        initComponents();

<<<<<<< HEAD
        // Start a background thread to handle the gRPC setup
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                // Build gRPC channel and stub for synchronous/blocking calls
                ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                        .usePlaintext()
                        .build();

                try {
                    // Call AuthService to get token
                    AuthServiceGrpc.AuthServiceBlockingStub authStub = AuthServiceGrpc.newBlockingStub(channel);

                    LoginResponse response = authStub.login(LoginRequest.newBuilder()
                            .setUsername("doctor123")
                            .setPassword("mypassword")
                            .build());

                    String jwtToken = response.getToken();

                    // Metadata
                    Metadata headers = new Metadata();
                    Metadata.Key<String> AUTHORIZATION_KEY = Metadata.Key.of("Authorization", Metadata.ASCII_STRING_MARSHALLER);
                    headers.put(AUTHORIZATION_KEY, "Bearer " + jwtToken);

                    // Attach headers to AppointmentService stub
                    appointmentStub = MetadataUtils.attachHeaders(AppointmentServiceGrpc.newBlockingStub(channel), headers);

                } catch (Exception e) {
                    e.printStackTrace(); // Handle or log exception here
                } finally {
                    // Clean up the channel after the operation is done
                    channel.shutdown();
                }

                return null;
            }

            @Override
            protected void done() {
                // This will run after the background task finishes on the EDT
                try {
                    // Ensure the stub is initialized before enabling buttons
                    if (appointmentStub != null) {
                        btnBook.setEnabled(true);
                        btnRetrieve.setEnabled(true);
                        btnLoadAvailability.setEnabled(true);
                    } else {
                        System.out.println("Error: appointmentStub not initialized.");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        worker.execute();

        // Add action listeners to buttons
=======
        // Initialize the gRPC connection
        channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();
        blockingStub = AppointmentServiceGrpc.newBlockingStub(channel);

        // Event handler: Book Appointment
>>>>>>> parent of fe9b6ec (Improvement on server)
        btnBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Ensure appointmentStub is initialized before using it
                if (appointmentStub != null) {
                    bookAppointment();
                } else {
                    System.out.println("Error: appointmentStub not initialized.");
                }
            }
        });

<<<<<<< HEAD
=======
        // Event handler: Get Appointment by ID
>>>>>>> parent of fe9b6ec (Improvement on server)
        btnRetrieve.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Ensure appointmentStub is initialized before using it
                if (appointmentStub != null) {
                    getAppointment();
                } else {
                    System.out.println("Error: appointmentStub not initialized.");
                }
            }
        });
<<<<<<< HEAD

        btnLoadAvailability.addActionListener(new ActionListener() {
=======
        
        // Event handler: Load availability
               btnLoadAvailability.addActionListener(new ActionListener() {
>>>>>>> parent of fe9b6ec (Improvement on server)
            public void actionPerformed(ActionEvent e) {
                // Ensure appointmentStub is initialized before using it
                if (appointmentStub != null) {
                    updateAvailableSlots();
                } else {
                    System.out.println("Error: appointmentStub not initialized.");
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // Build the GUI layout and components
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblPatient = new javax.swing.JLabel();
        txtPatient = new javax.swing.JTextField();
        lblDoctor = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        btnBook = new javax.swing.JButton();
        lblAppointmentId = new javax.swing.JLabel();
        txtAppointmentId = new javax.swing.JTextField();
        btnRetrieve = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtResult = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jComboTime = new javax.swing.JComboBox<>();
        txtDoctor = new javax.swing.JTextField();
        btnLoadAvailability = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblPatient.setText("Patient ID");

        txtPatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPatientActionPerformed(evt);
            }
        });

        lblDoctor.setText("Doctor ID");

        lblTime.setText("Appointment Time");

        btnBook.setText("Book Appointment");

        lblAppointmentId.setText("Appointment ID");

        txtAppointmentId.setText("APPT-");
        txtAppointmentId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAppointmentIdActionPerformed(evt);
            }
        });

        btnRetrieve.setText("Get Appointment");

        txtResult.setColumns(20);
        txtResult.setRows(5);
        jScrollPane1.setViewportView(txtResult);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Book Appointment");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Check Appointments");

        jComboTime.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enter a Doctor ID first" }));

        btnLoadAvailability.setText("Load Availability");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBook, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRetrieve, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPatient)
                            .addComponent(lblDoctor)
                            .addComponent(lblTime))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPatient)
                            .addComponent(jComboTime, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLoadAvailability, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblAppointmentId)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtAppointmentId, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPatient)
                    .addComponent(txtPatient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDoctor)
                    .addComponent(txtDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLoadAvailability))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTime)
                    .addComponent(jComboTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnBook)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAppointmentId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAppointmentId))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRetrieve)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPatientActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPatientActionPerformed

    private void txtAppointmentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAppointmentIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAppointmentIdActionPerformed

 private void updateAvailableSlots() {
        String doctorId = txtDoctor.getText().trim();
        jComboTime.removeAllItems();

        if (doctorId.isEmpty()) {
            jComboTime.addItem("Enter a Doctor ID first");
            return;
        }

        AvailabilityRequest request = AvailabilityRequest.newBuilder()
                .setDoctorId(doctorId)
                .build();

        try {
            Iterator<AvailabilityResponse> responses = appointmentStub.getAvailability(request);
            boolean hasSlots = false;

            while (responses.hasNext()) {
                hasSlots = true;
                String slot = responses.next().getDateTime();
                jComboTime.addItem(slot);
            }

            if (!hasSlots) {
                jComboTime.addItem("No available slots");
            }
        } catch (Exception e) {
            jComboTime.addItem("Error fetching slots");
            e.printStackTrace();
        }
    }

    // Handles booking an appointment
    private void bookAppointment() {
        String patientId = txtPatient.getText().trim();
        String doctorId = txtDoctor.getText().trim();
        String dateTime = (String) jComboTime.getSelectedItem();

        AppointmentRequest request = AppointmentRequest.newBuilder()
                .setPatientId(patientId)
                .setDoctorId(doctorId)
                .setDateTime(dateTime)
                .build();

        AppointmentResponse response = appointmentStub.scheduleAppointment(request);

        if (response.getSuccess()) {
            txtResult.setText("Appointment booked successfully!\nMessage: " + response.getMessage());
        } else {
            txtResult.setText("Failed to book appointment.\nMessage: " + response.getMessage());
        }
    }

    // Handles retrieving an appointment by ID
    private void getAppointment() {
        String appointmentId = txtAppointmentId.getText().trim();

        AppointmentIdRequest request = AppointmentIdRequest.newBuilder()
                .setAppointmentId(appointmentId)
                .build();

        AppointmentResponse response = appointmentStub.getAppointment(request);

        if (response.getSuccess()) {
            txtResult.setText("Appointment details:\n" + response.getMessage());
        } else {
            txtResult.setText("Failed to get the appointment.\nMessage: " + response.getMessage());
        }
    }

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
            java.util.logging.Logger.getLogger(AppointmentGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AppointmentGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AppointmentGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AppointmentGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AppointmentGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBook;
    private javax.swing.JButton btnLoadAvailability;
    private javax.swing.JButton btnRetrieve;
    private javax.swing.JComboBox<String> jComboTime;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblAppointmentId;
    private javax.swing.JLabel lblDoctor;
    private javax.swing.JLabel lblPatient;
    private javax.swing.JLabel lblTime;
    private javax.swing.JTextField txtAppointmentId;
    private javax.swing.JTextField txtDoctor;
    private javax.swing.JTextField txtPatient;
    private javax.swing.JTextArea txtResult;
    // End of variables declaration//GEN-END:variables
}
