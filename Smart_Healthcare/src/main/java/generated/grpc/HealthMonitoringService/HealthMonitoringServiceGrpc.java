package generated.grpc.HealthMonitoringService;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.52.1)",
    comments = "Source: HealthMonitoringService.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class HealthMonitoringServiceGrpc {

  private HealthMonitoringServiceGrpc() {}

  public static final String SERVICE_NAME = "HealthMonitoringService.HealthMonitoringService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<generated.grpc.HealthMonitoringService.HealthDataRequest,
      generated.grpc.HealthMonitoringService.HealthDataResponse> getSendHealthDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SendHealthData",
      requestType = generated.grpc.HealthMonitoringService.HealthDataRequest.class,
      responseType = generated.grpc.HealthMonitoringService.HealthDataResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<generated.grpc.HealthMonitoringService.HealthDataRequest,
      generated.grpc.HealthMonitoringService.HealthDataResponse> getSendHealthDataMethod() {
    io.grpc.MethodDescriptor<generated.grpc.HealthMonitoringService.HealthDataRequest, generated.grpc.HealthMonitoringService.HealthDataResponse> getSendHealthDataMethod;
    if ((getSendHealthDataMethod = HealthMonitoringServiceGrpc.getSendHealthDataMethod) == null) {
      synchronized (HealthMonitoringServiceGrpc.class) {
        if ((getSendHealthDataMethod = HealthMonitoringServiceGrpc.getSendHealthDataMethod) == null) {
          HealthMonitoringServiceGrpc.getSendHealthDataMethod = getSendHealthDataMethod =
              io.grpc.MethodDescriptor.<generated.grpc.HealthMonitoringService.HealthDataRequest, generated.grpc.HealthMonitoringService.HealthDataResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SendHealthData"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.grpc.HealthMonitoringService.HealthDataRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.grpc.HealthMonitoringService.HealthDataResponse.getDefaultInstance()))
              .setSchemaDescriptor(new HealthMonitoringServiceMethodDescriptorSupplier("SendHealthData"))
              .build();
        }
      }
    }
    return getSendHealthDataMethod;
  }

  private static volatile io.grpc.MethodDescriptor<generated.grpc.HealthMonitoringService.EmergencyAlertRequest,
      generated.grpc.HealthMonitoringService.EmergencyAlertResponse> getAlertEmergencyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AlertEmergency",
      requestType = generated.grpc.HealthMonitoringService.EmergencyAlertRequest.class,
      responseType = generated.grpc.HealthMonitoringService.EmergencyAlertResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<generated.grpc.HealthMonitoringService.EmergencyAlertRequest,
      generated.grpc.HealthMonitoringService.EmergencyAlertResponse> getAlertEmergencyMethod() {
    io.grpc.MethodDescriptor<generated.grpc.HealthMonitoringService.EmergencyAlertRequest, generated.grpc.HealthMonitoringService.EmergencyAlertResponse> getAlertEmergencyMethod;
    if ((getAlertEmergencyMethod = HealthMonitoringServiceGrpc.getAlertEmergencyMethod) == null) {
      synchronized (HealthMonitoringServiceGrpc.class) {
        if ((getAlertEmergencyMethod = HealthMonitoringServiceGrpc.getAlertEmergencyMethod) == null) {
          HealthMonitoringServiceGrpc.getAlertEmergencyMethod = getAlertEmergencyMethod =
              io.grpc.MethodDescriptor.<generated.grpc.HealthMonitoringService.EmergencyAlertRequest, generated.grpc.HealthMonitoringService.EmergencyAlertResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AlertEmergency"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.grpc.HealthMonitoringService.EmergencyAlertRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.grpc.HealthMonitoringService.EmergencyAlertResponse.getDefaultInstance()))
              .setSchemaDescriptor(new HealthMonitoringServiceMethodDescriptorSupplier("AlertEmergency"))
              .build();
        }
      }
    }
    return getAlertEmergencyMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static HealthMonitoringServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HealthMonitoringServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<HealthMonitoringServiceStub>() {
        @java.lang.Override
        public HealthMonitoringServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new HealthMonitoringServiceStub(channel, callOptions);
        }
      };
    return HealthMonitoringServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static HealthMonitoringServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HealthMonitoringServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<HealthMonitoringServiceBlockingStub>() {
        @java.lang.Override
        public HealthMonitoringServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new HealthMonitoringServiceBlockingStub(channel, callOptions);
        }
      };
    return HealthMonitoringServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static HealthMonitoringServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HealthMonitoringServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<HealthMonitoringServiceFutureStub>() {
        @java.lang.Override
        public HealthMonitoringServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new HealthMonitoringServiceFutureStub(channel, callOptions);
        }
      };
    return HealthMonitoringServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class HealthMonitoringServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Streams real-time health data from IoT devices. (Client Streaming RPC)
     * </pre>
     */
    public io.grpc.stub.StreamObserver<generated.grpc.HealthMonitoringService.HealthDataRequest> sendHealthData(
        io.grpc.stub.StreamObserver<generated.grpc.HealthMonitoringService.HealthDataResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getSendHealthDataMethod(), responseObserver);
    }

    /**
     * <pre>
     * Sends emergency alerts if critical health conditions are detected. (Bidirectional Streaming RPC)
     * </pre>
     */
    public io.grpc.stub.StreamObserver<generated.grpc.HealthMonitoringService.EmergencyAlertRequest> alertEmergency(
        io.grpc.stub.StreamObserver<generated.grpc.HealthMonitoringService.EmergencyAlertResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getAlertEmergencyMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSendHealthDataMethod(),
            io.grpc.stub.ServerCalls.asyncClientStreamingCall(
              new MethodHandlers<
                generated.grpc.HealthMonitoringService.HealthDataRequest,
                generated.grpc.HealthMonitoringService.HealthDataResponse>(
                  this, METHODID_SEND_HEALTH_DATA)))
          .addMethod(
            getAlertEmergencyMethod(),
            io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
              new MethodHandlers<
                generated.grpc.HealthMonitoringService.EmergencyAlertRequest,
                generated.grpc.HealthMonitoringService.EmergencyAlertResponse>(
                  this, METHODID_ALERT_EMERGENCY)))
          .build();
    }
  }

  /**
   */
  public static final class HealthMonitoringServiceStub extends io.grpc.stub.AbstractAsyncStub<HealthMonitoringServiceStub> {
    private HealthMonitoringServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HealthMonitoringServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HealthMonitoringServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Streams real-time health data from IoT devices. (Client Streaming RPC)
     * </pre>
     */
    public io.grpc.stub.StreamObserver<generated.grpc.HealthMonitoringService.HealthDataRequest> sendHealthData(
        io.grpc.stub.StreamObserver<generated.grpc.HealthMonitoringService.HealthDataResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getSendHealthDataMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * Sends emergency alerts if critical health conditions are detected. (Bidirectional Streaming RPC)
     * </pre>
     */
    public io.grpc.stub.StreamObserver<generated.grpc.HealthMonitoringService.EmergencyAlertRequest> alertEmergency(
        io.grpc.stub.StreamObserver<generated.grpc.HealthMonitoringService.EmergencyAlertResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getAlertEmergencyMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class HealthMonitoringServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<HealthMonitoringServiceBlockingStub> {
    private HealthMonitoringServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HealthMonitoringServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HealthMonitoringServiceBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class HealthMonitoringServiceFutureStub extends io.grpc.stub.AbstractFutureStub<HealthMonitoringServiceFutureStub> {
    private HealthMonitoringServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HealthMonitoringServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HealthMonitoringServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_SEND_HEALTH_DATA = 0;
  private static final int METHODID_ALERT_EMERGENCY = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final HealthMonitoringServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(HealthMonitoringServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEND_HEALTH_DATA:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.sendHealthData(
              (io.grpc.stub.StreamObserver<generated.grpc.HealthMonitoringService.HealthDataResponse>) responseObserver);
        case METHODID_ALERT_EMERGENCY:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.alertEmergency(
              (io.grpc.stub.StreamObserver<generated.grpc.HealthMonitoringService.EmergencyAlertResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class HealthMonitoringServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    HealthMonitoringServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return generated.grpc.HealthMonitoringService.HealthMonitoringServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("HealthMonitoringService");
    }
  }

  private static final class HealthMonitoringServiceFileDescriptorSupplier
      extends HealthMonitoringServiceBaseDescriptorSupplier {
    HealthMonitoringServiceFileDescriptorSupplier() {}
  }

  private static final class HealthMonitoringServiceMethodDescriptorSupplier
      extends HealthMonitoringServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    HealthMonitoringServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (HealthMonitoringServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new HealthMonitoringServiceFileDescriptorSupplier())
              .addMethod(getSendHealthDataMethod())
              .addMethod(getAlertEmergencyMethod())
              .build();
        }
      }
    }
    return result;
  }
}
