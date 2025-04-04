// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: HealthMonitoringService.proto

package generated.grpc.HealthMonitoringService;

public interface EmergencyAlertRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:HealthMonitoringService.EmergencyAlertRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * Patient's unique identifier
   * </pre>
   *
   * <code>string patient_id = 1;</code>
   * @return The patientId.
   */
  java.lang.String getPatientId();
  /**
   * <pre>
   * Patient's unique identifier
   * </pre>
   *
   * <code>string patient_id = 1;</code>
   * @return The bytes for patientId.
   */
  com.google.protobuf.ByteString
      getPatientIdBytes();

  /**
   * <pre>
   * Example: "Heart Rate Spike", "High Temperature"
   * </pre>
   *
   * <code>string alert_type = 2;</code>
   * @return The alertType.
   */
  java.lang.String getAlertType();
  /**
   * <pre>
   * Example: "Heart Rate Spike", "High Temperature"
   * </pre>
   *
   * <code>string alert_type = 2;</code>
   * @return The bytes for alertType.
   */
  com.google.protobuf.ByteString
      getAlertTypeBytes();
}
