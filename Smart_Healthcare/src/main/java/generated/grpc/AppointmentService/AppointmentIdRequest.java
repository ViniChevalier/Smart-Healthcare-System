// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: AppointmentService.proto

package generated.grpc.AppointmentService;

/**
 * <pre>
 * Request message for getting appointment by ID
 * </pre>
 *
 * Protobuf type {@code AppointmentService.AppointmentIdRequest}
 */
public final class AppointmentIdRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:AppointmentService.AppointmentIdRequest)
    AppointmentIdRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use AppointmentIdRequest.newBuilder() to construct.
  private AppointmentIdRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private AppointmentIdRequest() {
    appointmentId_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new AppointmentIdRequest();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private AppointmentIdRequest(
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

            appointmentId_ = s;
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
    return generated.grpc.AppointmentService.AppointmentServiceImpl.internal_static_AppointmentService_AppointmentIdRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return generated.grpc.AppointmentService.AppointmentServiceImpl.internal_static_AppointmentService_AppointmentIdRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            generated.grpc.AppointmentService.AppointmentIdRequest.class, generated.grpc.AppointmentService.AppointmentIdRequest.Builder.class);
  }

  public static final int APPOINTMENT_ID_FIELD_NUMBER = 1;
  private volatile java.lang.Object appointmentId_;
  /**
   * <pre>
   * List of scheduled appointments
   * </pre>
   *
   * <code>string appointment_id = 1;</code>
   * @return The appointmentId.
   */
  @java.lang.Override
  public java.lang.String getAppointmentId() {
    java.lang.Object ref = appointmentId_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      appointmentId_ = s;
      return s;
    }
  }
  /**
   * <pre>
   * List of scheduled appointments
   * </pre>
   *
   * <code>string appointment_id = 1;</code>
   * @return The bytes for appointmentId.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getAppointmentIdBytes() {
    java.lang.Object ref = appointmentId_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      appointmentId_ = b;
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
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(appointmentId_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, appointmentId_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(appointmentId_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, appointmentId_);
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
    if (!(obj instanceof generated.grpc.AppointmentService.AppointmentIdRequest)) {
      return super.equals(obj);
    }
    generated.grpc.AppointmentService.AppointmentIdRequest other = (generated.grpc.AppointmentService.AppointmentIdRequest) obj;

    if (!getAppointmentId()
        .equals(other.getAppointmentId())) return false;
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
    hash = (37 * hash) + APPOINTMENT_ID_FIELD_NUMBER;
    hash = (53 * hash) + getAppointmentId().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static generated.grpc.AppointmentService.AppointmentIdRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static generated.grpc.AppointmentService.AppointmentIdRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static generated.grpc.AppointmentService.AppointmentIdRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static generated.grpc.AppointmentService.AppointmentIdRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static generated.grpc.AppointmentService.AppointmentIdRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static generated.grpc.AppointmentService.AppointmentIdRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static generated.grpc.AppointmentService.AppointmentIdRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static generated.grpc.AppointmentService.AppointmentIdRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static generated.grpc.AppointmentService.AppointmentIdRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static generated.grpc.AppointmentService.AppointmentIdRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static generated.grpc.AppointmentService.AppointmentIdRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static generated.grpc.AppointmentService.AppointmentIdRequest parseFrom(
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
  public static Builder newBuilder(generated.grpc.AppointmentService.AppointmentIdRequest prototype) {
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
   * Request message for getting appointment by ID
   * </pre>
   *
   * Protobuf type {@code AppointmentService.AppointmentIdRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:AppointmentService.AppointmentIdRequest)
      generated.grpc.AppointmentService.AppointmentIdRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return generated.grpc.AppointmentService.AppointmentServiceImpl.internal_static_AppointmentService_AppointmentIdRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return generated.grpc.AppointmentService.AppointmentServiceImpl.internal_static_AppointmentService_AppointmentIdRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              generated.grpc.AppointmentService.AppointmentIdRequest.class, generated.grpc.AppointmentService.AppointmentIdRequest.Builder.class);
    }

    // Construct using generated.grpc.AppointmentService.AppointmentIdRequest.newBuilder()
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
      appointmentId_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return generated.grpc.AppointmentService.AppointmentServiceImpl.internal_static_AppointmentService_AppointmentIdRequest_descriptor;
    }

    @java.lang.Override
    public generated.grpc.AppointmentService.AppointmentIdRequest getDefaultInstanceForType() {
      return generated.grpc.AppointmentService.AppointmentIdRequest.getDefaultInstance();
    }

    @java.lang.Override
    public generated.grpc.AppointmentService.AppointmentIdRequest build() {
      generated.grpc.AppointmentService.AppointmentIdRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public generated.grpc.AppointmentService.AppointmentIdRequest buildPartial() {
      generated.grpc.AppointmentService.AppointmentIdRequest result = new generated.grpc.AppointmentService.AppointmentIdRequest(this);
      result.appointmentId_ = appointmentId_;
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
      if (other instanceof generated.grpc.AppointmentService.AppointmentIdRequest) {
        return mergeFrom((generated.grpc.AppointmentService.AppointmentIdRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(generated.grpc.AppointmentService.AppointmentIdRequest other) {
      if (other == generated.grpc.AppointmentService.AppointmentIdRequest.getDefaultInstance()) return this;
      if (!other.getAppointmentId().isEmpty()) {
        appointmentId_ = other.appointmentId_;
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
      generated.grpc.AppointmentService.AppointmentIdRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (generated.grpc.AppointmentService.AppointmentIdRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object appointmentId_ = "";
    /**
     * <pre>
     * List of scheduled appointments
     * </pre>
     *
     * <code>string appointment_id = 1;</code>
     * @return The appointmentId.
     */
    public java.lang.String getAppointmentId() {
      java.lang.Object ref = appointmentId_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        appointmentId_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     * List of scheduled appointments
     * </pre>
     *
     * <code>string appointment_id = 1;</code>
     * @return The bytes for appointmentId.
     */
    public com.google.protobuf.ByteString
        getAppointmentIdBytes() {
      java.lang.Object ref = appointmentId_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        appointmentId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     * List of scheduled appointments
     * </pre>
     *
     * <code>string appointment_id = 1;</code>
     * @param value The appointmentId to set.
     * @return This builder for chaining.
     */
    public Builder setAppointmentId(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      appointmentId_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * List of scheduled appointments
     * </pre>
     *
     * <code>string appointment_id = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearAppointmentId() {
      
      appointmentId_ = getDefaultInstance().getAppointmentId();
      onChanged();
      return this;
    }
    /**
     * <pre>
     * List of scheduled appointments
     * </pre>
     *
     * <code>string appointment_id = 1;</code>
     * @param value The bytes for appointmentId to set.
     * @return This builder for chaining.
     */
    public Builder setAppointmentIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      appointmentId_ = value;
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


    // @@protoc_insertion_point(builder_scope:AppointmentService.AppointmentIdRequest)
  }

  // @@protoc_insertion_point(class_scope:AppointmentService.AppointmentIdRequest)
  private static final generated.grpc.AppointmentService.AppointmentIdRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new generated.grpc.AppointmentService.AppointmentIdRequest();
  }

  public static generated.grpc.AppointmentService.AppointmentIdRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<AppointmentIdRequest>
      PARSER = new com.google.protobuf.AbstractParser<AppointmentIdRequest>() {
    @java.lang.Override
    public AppointmentIdRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new AppointmentIdRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<AppointmentIdRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<AppointmentIdRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public generated.grpc.AppointmentService.AppointmentIdRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

