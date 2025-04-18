/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package distsys.smart_healthcare;

import distsys.smart_healthcare.Auth.Constants;
import generated.grpc.HealthMonitoringService.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Metadata;
import io.grpc.stub.MetadataUtils;
import io.grpc.stub.StreamObserver;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.logging.Logger;

/**
 *
 * @author vinicius
 */
public class HealthMonitoringGUI extends javax.swing.JFrame {

    // Metadata
    private static final Logger logger = Logger.getLogger(HealthMonitoringGUI.class.getName());

    // gRPC channel and stubs for communication
    private ManagedChannel channel;
    private HealthMonitoringServiceGrpc.HealthMonitoringServiceStub asyncStub;

    private StreamObserver<HealthDataRequest> healthDataStream;
    private StreamObserver<EmergencyAlertRequest> emergencyStream;

    // Counter to track the number of streams
    private int streamCount = 0;

    /**
     * Creates new form HealthMonitoringClient
     */
    //Constructor
    public HealthMonitoringGUI() {
        initComponents();
        setupGrpcClient();
        setupStreams();
        setupActionListeners();
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

        asyncStub = MetadataUtils.attachHeaders(HealthMonitoringServiceGrpc.newStub(channel), headers);
    }

    // Generate a valid token
    private static String getJwt() {
        return Jwts.builder()
                .setSubject("Health Monitoring GUI (Client)") // client's identifier
                .signWith(SignatureAlgorithm.HS256, Constants.JWT_SIGNING_KEY)
                .compact();
    }

    private void setupStreams() {
        healthDataStream = createHealthDataStream();

        emergencyStream = asyncStub.alertEmergency(new StreamObserver<EmergencyAlertResponse>() {
            @Override
            public void onNext(EmergencyAlertResponse response) {
                txtEmergencyResponse.append(response.getConfirmation() + "\n");
            }

            @Override
            public void onError(Throwable t) {
                String userMessage;
                String logMessage = "Emergency stream error: " + t.getMessage();

                if (t instanceof io.grpc.StatusRuntimeException) {
                    io.grpc.StatusRuntimeException ex = (io.grpc.StatusRuntimeException) t;

                    if (ex.getStatus().getCode() == io.grpc.Status.Code.UNAVAILABLE) {
                        userMessage = "Emergency service is unavailable. Please check your connection.";
                    } else {
                        userMessage = "An error occurred: " + ex.getStatus().getDescription();
                    }
                } else {
                    userMessage = "Unexpected error: " + t.getMessage();
                }

                txtEmergencyResponse.append(userMessage + "\n");

                // Log the error
                System.err.println(logMessage);
            }

            @Override
            public void onCompleted() {
                txtEmergencyResponse.append("[System] Emergency stream closed by server.\n");
            }
        });
    }

    private StreamObserver<HealthDataRequest> createHealthDataStream() {
        return asyncStub.sendHealthData(new StreamObserver<HealthDataResponse>() {
            @Override
            public void onNext(HealthDataResponse value) {
                txtHealthData.append("Server Response: " + value.getMessage() + "\n");
            }

            @Override
            public void onError(Throwable t) {
                String userMessage;
                String logMessage = "Health data stream error: " + t.getMessage();

                if (t instanceof io.grpc.StatusRuntimeException) {
                    io.grpc.StatusRuntimeException ex = (io.grpc.StatusRuntimeException) t;

                    if (ex.getStatus().getCode() == io.grpc.Status.Code.UNAVAILABLE) {
                        userMessage = "Health monitoring service is unavailable. Please check your connection.";
                    } else {
                        userMessage = "An error occurred: " + ex.getStatus().getDescription();
                    }
                } else {
                    userMessage = "Unexpected error: " + t.getMessage();
                }

                txtHealthData.append(userMessage + "\n");

                // Log the full error
                System.err.println(logMessage);
            }

            @Override
            public void onCompleted() {
                txtHealthData.append("[System] Health data stream completed.\n");
            }
        });
    }

    private void setupActionListeners() {
        btnSendHealthData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendHealthData();
            }
        });

        btnSendAlert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendEmergencyAlert();
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

        jCheckBox1 = new javax.swing.JCheckBox();
        healthDataPanel = new javax.swing.JPanel();
        txtPatientId = new javax.swing.JTextField();
        txtHeartRate = new javax.swing.JTextField();
        txtTemperature = new javax.swing.JTextField();
        txtDeviceId = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnSendHealthData = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtHealthData = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        emergencyAlertPanel = new javax.swing.JPanel();
        txtAlertPatientId = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        comboAlertType = new javax.swing.JComboBox<>();
        btnSendAlert = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtEmergencyResponse = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();

        jCheckBox1.setText("jCheckBox1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtDeviceId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDeviceIdActionPerformed(evt);
            }
        });

        jLabel1.setText("Patient ID");

        jLabel2.setText("Heart Rate");

        jLabel3.setText("Temperature");

        jLabel4.setText("Device ID");

        btnSendHealthData.setText("Send Health Data");
        btnSendHealthData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendHealthDataActionPerformed(evt);
            }
        });

        txtHealthData.setEditable(false);
        txtHealthData.setColumns(20);
        txtHealthData.setRows(5);
        jScrollPane2.setViewportView(txtHealthData);

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Send Health Data");

        javax.swing.GroupLayout healthDataPanelLayout = new javax.swing.GroupLayout(healthDataPanel);
        healthDataPanel.setLayout(healthDataPanelLayout);
        healthDataPanelLayout.setHorizontalGroup(
            healthDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(healthDataPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(healthDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(healthDataPanelLayout.createSequentialGroup()
                        .addGroup(healthDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, healthDataPanelLayout.createSequentialGroup()
                                .addGap(0, 658, Short.MAX_VALUE)
                                .addComponent(btnSendHealthData, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, healthDataPanelLayout.createSequentialGroup()
                                .addGroup(healthDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(healthDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtHeartRate)
                                    .addComponent(txtPatientId)
                                    .addComponent(txtTemperature)
                                    .addComponent(txtDeviceId))))
                        .addContainerGap())))
        );
        healthDataPanelLayout.setVerticalGroup(
            healthDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(healthDataPanelLayout.createSequentialGroup()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(healthDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPatientId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(healthDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHeartRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(healthDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTemperature, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(healthDataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDeviceId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSendHealthData)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel5.setText("Alert Patient ID");

        comboAlertType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Heart", "Temperature", "Fall" }));

        btnSendAlert.setText("Send Alert");

        jLabel6.setText("Alert Type");

        txtEmergencyResponse.setEditable(false);
        txtEmergencyResponse.setColumns(20);
        txtEmergencyResponse.setRows(5);
        jScrollPane3.setViewportView(txtEmergencyResponse);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Emergency Alert");

        javax.swing.GroupLayout emergencyAlertPanelLayout = new javax.swing.GroupLayout(emergencyAlertPanel);
        emergencyAlertPanel.setLayout(emergencyAlertPanelLayout);
        emergencyAlertPanelLayout.setHorizontalGroup(
            emergencyAlertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(emergencyAlertPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(emergencyAlertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(emergencyAlertPanelLayout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(emergencyAlertPanelLayout.createSequentialGroup()
                        .addGroup(emergencyAlertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(emergencyAlertPanelLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel6)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(emergencyAlertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(emergencyAlertPanelLayout.createSequentialGroup()
                                .addComponent(comboAlertType, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSendAlert, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtAlertPatientId, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 672, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );
        emergencyAlertPanelLayout.setVerticalGroup(
            emergencyAlertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(emergencyAlertPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(5, 5, 5)
                .addGroup(emergencyAlertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAlertPatientId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(emergencyAlertPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboAlertType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(btnSendAlert))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(healthDataPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(emergencyAlertPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(healthDataPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emergencyAlertPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDeviceIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDeviceIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDeviceIdActionPerformed

    private void btnSendHealthDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendHealthDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSendHealthDataActionPerformed

    private void sendHealthData() {
        try {
            // Check if any required fields are empty, and show an error message if so
            if (txtPatientId.getText().trim().isEmpty()
                    || txtHeartRate.getText().trim().isEmpty()
                    || txtTemperature.getText().trim().isEmpty()
                    || txtDeviceId.getText().trim().isEmpty()) {

                txtHealthData.append("Error: All fields must be filled!\n");
                return;
            }

            // User input
            String patientId = txtPatientId.getText().trim();
            int heartRate = Integer.parseInt(txtHeartRate.getText().trim());
            float temperature = Float.parseFloat(txtTemperature.getText().trim());
            String deviceId = txtDeviceId.getText().trim();

            HealthDataRequest data = HealthDataRequest.newBuilder()
                    .setPatientId(patientId)
                    .setHeartRate(heartRate)
                    .setTemperature(temperature)
                    .setDeviceId(deviceId)
                    .build();

            // Send the health data through the stream
            healthDataStream.onNext(data);
            streamCount++;
            txtHealthData.append("Data streamed. " + (5 - streamCount) + " more streams remaining.\n");

            // If 5 streams are completed, finish the stream and re-enable streaming
            if (streamCount >= 5) {
                healthDataStream.onCompleted();
                txtHealthData.append("Streaming completed.\n");

                // Re-enable streaming: reset the stream count and create a new stream
                streamCount = 0;
                healthDataStream = asyncStub.sendHealthData(new StreamObserver<HealthDataResponse>() {
                    @Override
                    public void onNext(HealthDataResponse value) {
                        // Handle the server's response for the stream
                        txtHealthData.append("Server Response: " + value.getMessage() + "\n");
                    }

                    @Override
                    public void onError(Throwable t) {
                        // Handle error in response
                        txtHealthData.append("Error: " + t.getMessage() + "\n");
                    }

                    @Override
                    public void onCompleted() {
                        // Log completion of the health data stream
                        System.out.println("Health data stream completed.");
                    }
                });

                txtHealthData.append("Stream re-initialized.\n");
            }

        } catch (NumberFormatException ex) {
            // Handle invalid number format
            txtHealthData.append("Error: Heart Rate and Temperature must be valid numbers!\n");
        } catch (Exception ex) {
            // Catch any other unexpected errors
            txtHealthData.append("Unexpected Error: " + ex.getMessage() + "\n");
        }
    }

    private void sendEmergencyAlert() {
        try {
            // Retrieve patient ID and alert type from the user input
            String patientId = txtAlertPatientId.getText();
            String alertType = comboAlertType.getSelectedItem().toString();

            // Generate random values for heart rate, temperature, and fall detection
            Random rand = new Random();
            int heartRate = rand.nextInt(61) + 60;
            double temperature = 35.0 + (rand.nextDouble() * 4);
            boolean fallDetected = alertType.equalsIgnoreCase("Fall");

            // Create Alert message
            String alertMessage
                    = "Emergency Alert: " + alertType + "\n"
                    + "- Heart Rate: " + heartRate + " bpm \n"
                    + "- Temperature: " + temperature + "°C \n"
                    + "- Fall Detected: " + fallDetected;

            EmergencyAlertRequest alert = EmergencyAlertRequest.newBuilder()
                    .setPatientId(patientId)
                    .setAlertType(alertType)
                    .setAlertMessage(alertMessage)
                    .build();

            // Send the emergency alert
            emergencyStream.onNext(alert);

            // Display the alert
            txtEmergencyResponse.append("Alert sent for patient ID: " + patientId + "\n");
            txtEmergencyResponse.append("Message streamed:\n" + alertMessage + "\n\n");

        } catch (Exception ex) {
            // Handle any errors that occur during alert sending
            txtEmergencyResponse.append("Failed to send alert: " + ex.getMessage() + "\n");
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
            java.util.logging.Logger.getLogger(HealthMonitoringGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HealthMonitoringGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HealthMonitoringGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HealthMonitoringGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HealthMonitoringGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSendAlert;
    private javax.swing.JButton btnSendHealthData;
    private javax.swing.JComboBox<String> comboAlertType;
    private javax.swing.JPanel emergencyAlertPanel;
    private javax.swing.JPanel healthDataPanel;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField txtAlertPatientId;
    private javax.swing.JTextField txtDeviceId;
    private javax.swing.JTextArea txtEmergencyResponse;
    private javax.swing.JTextArea txtHealthData;
    private javax.swing.JTextField txtHeartRate;
    private javax.swing.JTextField txtPatientId;
    private javax.swing.JTextField txtTemperature;
    // End of variables declaration//GEN-END:variables
}
