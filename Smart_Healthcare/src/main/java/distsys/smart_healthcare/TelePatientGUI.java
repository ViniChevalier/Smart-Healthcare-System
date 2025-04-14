/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package distsys.smart_healthcare;

/**
 *
 * @author vinicius
 */
import distsys.smart_healthcare.Auth.Constants;
import generated.grpc.TelemedicineService.*;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Metadata;
import io.grpc.stub.MetadataUtils;
import io.grpc.stub.StreamObserver;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.logging.Logger;

import javax.swing.*;

public class TelePatientGUI extends javax.swing.JFrame {
    
    // Metadata
    private static final Logger logger = Logger.getLogger(TelePatientGUI.class.getName());

    // gRPC channel and stubs for communication
    private ManagedChannel channel;

    private TelemedicineServiceGrpc.TelemedicineServiceStub asyncStub;
    private TelemedicineServiceGrpc.TelemedicineServiceBlockingStub blockingStub;
    private StreamObserver<MessageRequest> chatRequestStream;

    /**
     * Creates new form TelePatientGUI
     */
    //Constructor
    public TelePatientGUI() {
        initComponents();
        setupGrpcClient();
        startChatStream();
    }

    // Setup GRPC
    private void setupGrpcClient() {
        channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();

        String jwt = getJwt();
        Metadata headers = new Metadata();
        Metadata.Key<String> jwtKey = Metadata.Key.of("authorization", Metadata.ASCII_STRING_MARSHALLER);
        headers.put(jwtKey, "Bearer " + jwt);

        asyncStub = MetadataUtils.attachHeaders(TelemedicineServiceGrpc.newStub(channel), headers);
        blockingStub = MetadataUtils.attachHeaders(TelemedicineServiceGrpc.newBlockingStub(channel), headers);
    }

    // Generate a valid token
    private static String getJwt() {
        return Jwts.builder()
                .setSubject("Telemedicine - Patient Client") // client's identifier
                .signWith(SignatureAlgorithm.HS256, Constants.JWT_SIGNING_KEY)
                .compact();
    }

    private void startChatStream() {
        // Start the chat stream using the async stub
        chatRequestStream = asyncStub.chat(new StreamObserver<MessageResponse>() {
            @Override
            public void onNext(MessageResponse value) {
                // If the received message is not from the "Patient", show it in the chat area
                if (!value.getSender().equals("Patient")) {
                    SwingUtilities.invokeLater(() -> {
                        chatArea.append(value.getSender() + ": " + value.getMessageText() + "\n");
                    });
                }
            }

            @Override
            public void onError(Throwable t) {
                SwingUtilities.invokeLater(() -> {
                    chatArea.append("Chat error: " + t.getMessage() + "\n");
                });
            }

            @Override
            public void onCompleted() {
                SwingUtilities.invokeLater(() -> {
                    chatArea.append("Chat session ended.\n");
                });
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        chatArea = new javax.swing.JTextArea();
        chatInput = new javax.swing.JTextField();
        sendButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtPatientId = new javax.swing.JTextField();
        btnStartConsultation = new javax.swing.JButton();
        txtDoctorId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        chatArea.setEditable(false);
        chatArea.setColumns(20);
        chatArea.setRows(5);
        jScrollPane1.setViewportView(chatArea);

        chatInput.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        chatInput.setActionCommand("<Not Set>");

        sendButton.setText("Send");
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Patient Telemedicine");

        jLabel2.setText("Patient ID");

        btnStartConsultation.setText("Start Consultation");
        btnStartConsultation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartConsultationActionPerformed(evt);
            }
        });

        txtDoctorId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDoctorIdActionPerformed(evt);
            }
        });

        jLabel3.setText("Doctor ID");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chatInput, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(sendButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDoctorId, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPatientId, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnStartConsultation, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtPatientId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDoctorId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addComponent(btnStartConsultation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chatInput, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sendButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
        // TODO add your handling code here:
        // Handle sending a message
        // Check if the message is not empty
        String message = chatInput.getText().trim();

        if (!message.isEmpty() && chatRequestStream != null) {
            chatRequestStream.onNext(MessageRequest.newBuilder()
                    .setSender("Patient")
                    .setMessageText(message)
                    .build());
            chatArea.append("You: " + message + "\n");
            chatInput.setText("");
        } else if (chatRequestStream == null) {
            chatArea.append("Error: Chat stream not available." + "\n");
        }

    }//GEN-LAST:event_sendButtonActionPerformed

    private void btnStartConsultationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartConsultationActionPerformed
        // TODO add your handling code here:
        // Handle starting a consultation session between doctor and patient
        String doctorId = txtDoctorId.getText().trim();
        String patientId = txtPatientId.getText().trim();

        // Check if either the patient or doctor ID is empty
        if (patientId.isEmpty() || doctorId.isEmpty()) {
            chatArea.append("Please enter both Patient ID and Doctor ID.\n");
            return;
        }

        // If both IDs are provided, initiate the consultation
        initiateConsultation(patientId, doctorId);
    }//GEN-LAST:event_btnStartConsultationActionPerformed

    private void txtDoctorIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDoctorIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDoctorIdActionPerformed

    private void initiateConsultation(String patientId, String doctorId) {
        // Create a ConsultationRequest with patient and doctor IDs
        ConsultationRequest request = ConsultationRequest.newBuilder()
                .setPatientId(patientId)
                .setDoctorId(doctorId)
                .build();

        try {
            // Send the request and get the response
            ConsultationResponse response = blockingStub.startConsultation(request);
            if (response.getSuccess()) {
                chatArea.append("Consultation started with Dr ID: " + doctorId + "\n");
            } else {
                chatArea.append("Failed to start consultation.\n");
            }
        } catch (Exception e) {
            // Handle any errors that occur during the consultation initiation
            chatArea.append("Error starting consultation: " + e.getMessage() + "\n");
        }
    }

    @Override
    public void dispose() {
        if (chatRequestStream != null) {
            chatRequestStream.onCompleted();
        }
        if (channel != null && !channel.isShutdown()) {
            channel.shutdown();
        }
        super.dispose();
    }

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
            java.util.logging.Logger.getLogger(TelePatientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelePatientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelePatientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelePatientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelePatientGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnStartConsultation;
    private javax.swing.JTextArea chatArea;
    private javax.swing.JTextField chatInput;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton sendButton;
    private javax.swing.JTextField txtDoctorId;
    private javax.swing.JTextField txtPatientId;
    // End of variables declaration//GEN-END:variables
}
