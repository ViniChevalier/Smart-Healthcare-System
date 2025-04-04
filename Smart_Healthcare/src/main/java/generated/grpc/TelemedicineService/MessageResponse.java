// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: TelemedicineService.proto

package generated.grpc.TelemedicineService;

/**
 * <pre>
 * Response message for chat messages.
 * </pre>
 *
 * Protobuf type {@code TelemedicineService.MessageResponse}
 */
public final class MessageResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:TelemedicineService.MessageResponse)
    MessageResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use MessageResponse.newBuilder() to construct.
  private MessageResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private MessageResponse() {
    senderId_ = "";
    messageText_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new MessageResponse();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private MessageResponse(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            senderId_ = s;
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            messageText_ = s;
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (com.google.protobuf.UninitializedMessageException e) {
      throw e.asInvalidProtocolBufferException().setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return generated.grpc.TelemedicineService.TelemedicineServiceImpl.internal_static_TelemedicineService_MessageResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return generated.grpc.TelemedicineService.TelemedicineServiceImpl.internal_static_TelemedicineService_MessageResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            generated.grpc.TelemedicineService.MessageResponse.class, generated.grpc.TelemedicineService.MessageResponse.Builder.class);
  }

  public static final int SENDER_ID_FIELD_NUMBER = 1;
  private volatile java.lang.Object senderId_;
  /**
   * <pre>
   * ID of the message sender (patient or doctor)
   * </pre>
   *
   * <code>string sender_id = 1;</code>
   * @return The senderId.
   */
  @java.lang.Override
  public java.lang.String getSenderId() {
    java.lang.Object ref = senderId_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      senderId_ = s;
      return s;
    }
  }
  /**
   * <pre>
   * ID of the message sender (patient or doctor)
   * </pre>
   *
   * <code>string sender_id = 1;</code>
   * @return The bytes for senderId.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getSenderIdBytes() {
    java.lang.Object ref = senderId_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      senderId_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int MESSAGE_TEXT_FIELD_NUMBER = 2;
  private volatile java.lang.Object messageText_;
  /**
   * <pre>
   * The chat message content
   * </pre>
   *
   * <code>string message_text = 2;</code>
   * @return The messageText.
   */
  @java.lang.Override
  public java.lang.String getMessageText() {
    java.lang.Object ref = messageText_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      messageText_ = s;
      return s;
    }
  }
  /**
   * <pre>
   * The chat message content
   * </pre>
   *
   * <code>string message_text = 2;</code>
   * @return The bytes for messageText.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getMessageTextBytes() {
    java.lang.Object ref = messageText_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      messageText_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(senderId_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, senderId_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(messageText_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, messageText_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(senderId_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, senderId_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(messageText_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, messageText_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof generated.grpc.TelemedicineService.MessageResponse)) {
      return super.equals(obj);
    }
    generated.grpc.TelemedicineService.MessageResponse other = (generated.grpc.TelemedicineService.MessageResponse) obj;

    if (!getSenderId()
        .equals(other.getSenderId())) return false;
    if (!getMessageText()
        .equals(other.getMessageText())) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + SENDER_ID_FIELD_NUMBER;
    hash = (53 * hash) + getSenderId().hashCode();
    hash = (37 * hash) + MESSAGE_TEXT_FIELD_NUMBER;
    hash = (53 * hash) + getMessageText().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static generated.grpc.TelemedicineService.MessageResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static generated.grpc.TelemedicineService.MessageResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static generated.grpc.TelemedicineService.MessageResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static generated.grpc.TelemedicineService.MessageResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static generated.grpc.TelemedicineService.MessageResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static generated.grpc.TelemedicineService.MessageResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static generated.grpc.TelemedicineService.MessageResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static generated.grpc.TelemedicineService.MessageResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static generated.grpc.TelemedicineService.MessageResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static generated.grpc.TelemedicineService.MessageResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static generated.grpc.TelemedicineService.MessageResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static generated.grpc.TelemedicineService.MessageResponse parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(generated.grpc.TelemedicineService.MessageResponse prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * <pre>
   * Response message for chat messages.
   * </pre>
   *
   * Protobuf type {@code TelemedicineService.MessageResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:TelemedicineService.MessageResponse)
      generated.grpc.TelemedicineService.MessageResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return generated.grpc.TelemedicineService.TelemedicineServiceImpl.internal_static_TelemedicineService_MessageResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return generated.grpc.TelemedicineService.TelemedicineServiceImpl.internal_static_TelemedicineService_MessageResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              generated.grpc.TelemedicineService.MessageResponse.class, generated.grpc.TelemedicineService.MessageResponse.Builder.class);
    }

    // Construct using generated.grpc.TelemedicineService.MessageResponse.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      senderId_ = "";

      messageText_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return generated.grpc.TelemedicineService.TelemedicineServiceImpl.internal_static_TelemedicineService_MessageResponse_descriptor;
    }

    @java.lang.Override
    public generated.grpc.TelemedicineService.MessageResponse getDefaultInstanceForType() {
      return generated.grpc.TelemedicineService.MessageResponse.getDefaultInstance();
    }

    @java.lang.Override
    public generated.grpc.TelemedicineService.MessageResponse build() {
      generated.grpc.TelemedicineService.MessageResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public generated.grpc.TelemedicineService.MessageResponse buildPartial() {
      generated.grpc.TelemedicineService.MessageResponse result = new generated.grpc.TelemedicineService.MessageResponse(this);
      result.senderId_ = senderId_;
      result.messageText_ = messageText_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof generated.grpc.TelemedicineService.MessageResponse) {
        return mergeFrom((generated.grpc.TelemedicineService.MessageResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(generated.grpc.TelemedicineService.MessageResponse other) {
      if (other == generated.grpc.TelemedicineService.MessageResponse.getDefaultInstance()) return this;
      if (!other.getSenderId().isEmpty()) {
        senderId_ = other.senderId_;
        onChanged();
      }
      if (!other.getMessageText().isEmpty()) {
        messageText_ = other.messageText_;
        onChanged();
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      generated.grpc.TelemedicineService.MessageResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (generated.grpc.TelemedicineService.MessageResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object senderId_ = "";
    /**
     * <pre>
     * ID of the message sender (patient or doctor)
     * </pre>
     *
     * <code>string sender_id = 1;</code>
     * @return The senderId.
     */
    public java.lang.String getSenderId() {
      java.lang.Object ref = senderId_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        senderId_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     * ID of the message sender (patient or doctor)
     * </pre>
     *
     * <code>string sender_id = 1;</code>
     * @return The bytes for senderId.
     */
    public com.google.protobuf.ByteString
        getSenderIdBytes() {
      java.lang.Object ref = senderId_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        senderId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     * ID of the message sender (patient or doctor)
     * </pre>
     *
     * <code>string sender_id = 1;</code>
     * @param value The senderId to set.
     * @return This builder for chaining.
     */
    public Builder setSenderId(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      senderId_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * ID of the message sender (patient or doctor)
     * </pre>
     *
     * <code>string sender_id = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearSenderId() {
      
      senderId_ = getDefaultInstance().getSenderId();
      onChanged();
      return this;
    }
    /**
     * <pre>
     * ID of the message sender (patient or doctor)
     * </pre>
     *
     * <code>string sender_id = 1;</code>
     * @param value The bytes for senderId to set.
     * @return This builder for chaining.
     */
    public Builder setSenderIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      senderId_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object messageText_ = "";
    /**
     * <pre>
     * The chat message content
     * </pre>
     *
     * <code>string message_text = 2;</code>
     * @return The messageText.
     */
    public java.lang.String getMessageText() {
      java.lang.Object ref = messageText_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        messageText_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     * The chat message content
     * </pre>
     *
     * <code>string message_text = 2;</code>
     * @return The bytes for messageText.
     */
    public com.google.protobuf.ByteString
        getMessageTextBytes() {
      java.lang.Object ref = messageText_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        messageText_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     * The chat message content
     * </pre>
     *
     * <code>string message_text = 2;</code>
     * @param value The messageText to set.
     * @return This builder for chaining.
     */
    public Builder setMessageText(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      messageText_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * The chat message content
     * </pre>
     *
     * <code>string message_text = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearMessageText() {
      
      messageText_ = getDefaultInstance().getMessageText();
      onChanged();
      return this;
    }
    /**
     * <pre>
     * The chat message content
     * </pre>
     *
     * <code>string message_text = 2;</code>
     * @param value The bytes for messageText to set.
     * @return This builder for chaining.
     */
    public Builder setMessageTextBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      messageText_ = value;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:TelemedicineService.MessageResponse)
  }

  // @@protoc_insertion_point(class_scope:TelemedicineService.MessageResponse)
  private static final generated.grpc.TelemedicineService.MessageResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new generated.grpc.TelemedicineService.MessageResponse();
  }

  public static generated.grpc.TelemedicineService.MessageResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<MessageResponse>
      PARSER = new com.google.protobuf.AbstractParser<MessageResponse>() {
    @java.lang.Override
    public MessageResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new MessageResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<MessageResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<MessageResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public generated.grpc.TelemedicineService.MessageResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

