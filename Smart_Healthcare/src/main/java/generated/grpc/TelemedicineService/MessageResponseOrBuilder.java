// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: TelemedicineService.proto

package generated.grpc.TelemedicineService;

public interface MessageResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:TelemedicineService.MessageResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * ID of the message sender (patient or doctor)
   * </pre>
   *
   * <code>string sender = 1;</code>
   * @return The sender.
   */
  java.lang.String getSender();
  /**
   * <pre>
   * ID of the message sender (patient or doctor)
   * </pre>
   *
   * <code>string sender = 1;</code>
   * @return The bytes for sender.
   */
  com.google.protobuf.ByteString
      getSenderBytes();

  /**
   * <pre>
   * The chat message content
   * </pre>
   *
   * <code>string message_text = 2;</code>
   * @return The messageText.
   */
  java.lang.String getMessageText();
  /**
   * <pre>
   * The chat message content
   * </pre>
   *
   * <code>string message_text = 2;</code>
   * @return The bytes for messageText.
   */
  com.google.protobuf.ByteString
      getMessageTextBytes();
}
