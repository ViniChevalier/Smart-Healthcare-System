package generated.grpc.AppointmentService;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.52.1)",
    comments = "Source: AppointmentService.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AppointmentServiceGrpc {

  private AppointmentServiceGrpc() {}

  public static final String SERVICE_NAME = "AppointmentService.AppointmentService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<generated.grpc.AppointmentService.AppointmentRequest,
      generated.grpc.AppointmentService.AppointmentResponse> getScheduleAppointmentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ScheduleAppointment",
      requestType = generated.grpc.AppointmentService.AppointmentRequest.class,
      responseType = generated.grpc.AppointmentService.AppointmentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.grpc.AppointmentService.AppointmentRequest,
      generated.grpc.AppointmentService.AppointmentResponse> getScheduleAppointmentMethod() {
    io.grpc.MethodDescriptor<generated.grpc.AppointmentService.AppointmentRequest, generated.grpc.AppointmentService.AppointmentResponse> getScheduleAppointmentMethod;
    if ((getScheduleAppointmentMethod = AppointmentServiceGrpc.getScheduleAppointmentMethod) == null) {
      synchronized (AppointmentServiceGrpc.class) {
        if ((getScheduleAppointmentMethod = AppointmentServiceGrpc.getScheduleAppointmentMethod) == null) {
          AppointmentServiceGrpc.getScheduleAppointmentMethod = getScheduleAppointmentMethod =
              io.grpc.MethodDescriptor.<generated.grpc.AppointmentService.AppointmentRequest, generated.grpc.AppointmentService.AppointmentResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ScheduleAppointment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.grpc.AppointmentService.AppointmentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.grpc.AppointmentService.AppointmentResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AppointmentServiceMethodDescriptorSupplier("ScheduleAppointment"))
              .build();
        }
      }
    }
    return getScheduleAppointmentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<generated.grpc.AppointmentService.AvailabilityRequest,
      generated.grpc.AppointmentService.AvailabilityResponse> getGetAvailabilityMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAvailability",
      requestType = generated.grpc.AppointmentService.AvailabilityRequest.class,
      responseType = generated.grpc.AppointmentService.AvailabilityResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<generated.grpc.AppointmentService.AvailabilityRequest,
      generated.grpc.AppointmentService.AvailabilityResponse> getGetAvailabilityMethod() {
    io.grpc.MethodDescriptor<generated.grpc.AppointmentService.AvailabilityRequest, generated.grpc.AppointmentService.AvailabilityResponse> getGetAvailabilityMethod;
    if ((getGetAvailabilityMethod = AppointmentServiceGrpc.getGetAvailabilityMethod) == null) {
      synchronized (AppointmentServiceGrpc.class) {
        if ((getGetAvailabilityMethod = AppointmentServiceGrpc.getGetAvailabilityMethod) == null) {
          AppointmentServiceGrpc.getGetAvailabilityMethod = getGetAvailabilityMethod =
              io.grpc.MethodDescriptor.<generated.grpc.AppointmentService.AvailabilityRequest, generated.grpc.AppointmentService.AvailabilityResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAvailability"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.grpc.AppointmentService.AvailabilityRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.grpc.AppointmentService.AvailabilityResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AppointmentServiceMethodDescriptorSupplier("GetAvailability"))
              .build();
        }
      }
    }
    return getGetAvailabilityMethod;
  }

  private static volatile io.grpc.MethodDescriptor<generated.grpc.AppointmentService.AppointmentIdRequest,
      generated.grpc.AppointmentService.AppointmentResponse> getGetAppointmentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAppointment",
      requestType = generated.grpc.AppointmentService.AppointmentIdRequest.class,
      responseType = generated.grpc.AppointmentService.AppointmentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.grpc.AppointmentService.AppointmentIdRequest,
      generated.grpc.AppointmentService.AppointmentResponse> getGetAppointmentMethod() {
    io.grpc.MethodDescriptor<generated.grpc.AppointmentService.AppointmentIdRequest, generated.grpc.AppointmentService.AppointmentResponse> getGetAppointmentMethod;
    if ((getGetAppointmentMethod = AppointmentServiceGrpc.getGetAppointmentMethod) == null) {
      synchronized (AppointmentServiceGrpc.class) {
        if ((getGetAppointmentMethod = AppointmentServiceGrpc.getGetAppointmentMethod) == null) {
          AppointmentServiceGrpc.getGetAppointmentMethod = getGetAppointmentMethod =
              io.grpc.MethodDescriptor.<generated.grpc.AppointmentService.AppointmentIdRequest, generated.grpc.AppointmentService.AppointmentResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAppointment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.grpc.AppointmentService.AppointmentIdRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.grpc.AppointmentService.AppointmentResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AppointmentServiceMethodDescriptorSupplier("GetAppointment"))
              .build();
        }
      }
    }
    return getGetAppointmentMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AppointmentServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AppointmentServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AppointmentServiceStub>() {
        @java.lang.Override
        public AppointmentServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AppointmentServiceStub(channel, callOptions);
        }
      };
    return AppointmentServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AppointmentServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AppointmentServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AppointmentServiceBlockingStub>() {
        @java.lang.Override
        public AppointmentServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AppointmentServiceBlockingStub(channel, callOptions);
        }
      };
    return AppointmentServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AppointmentServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AppointmentServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AppointmentServiceFutureStub>() {
        @java.lang.Override
        public AppointmentServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AppointmentServiceFutureStub(channel, callOptions);
        }
      };
    return AppointmentServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class AppointmentServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Schedules an appointment for a patient. (Unary RPC)
     * </pre>
     */
    public void scheduleAppointment(generated.grpc.AppointmentService.AppointmentRequest request,
        io.grpc.stub.StreamObserver<generated.grpc.AppointmentService.AppointmentResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getScheduleAppointmentMethod(), responseObserver);
    }

    /**
     * <pre>
     * Streams available appointment slots for a doctor. (Server Streaming RPC)
     * </pre>
     */
    public void getAvailability(generated.grpc.AppointmentService.AvailabilityRequest request,
        io.grpc.stub.StreamObserver<generated.grpc.AppointmentService.AvailabilityResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAvailabilityMethod(), responseObserver);
    }

    /**
     * <pre>
     * Retrieves a scheduled appointment by its ID. (Unary RPC)
     * </pre>
     */
    public void getAppointment(generated.grpc.AppointmentService.AppointmentIdRequest request,
        io.grpc.stub.StreamObserver<generated.grpc.AppointmentService.AppointmentResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAppointmentMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getScheduleAppointmentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                generated.grpc.AppointmentService.AppointmentRequest,
                generated.grpc.AppointmentService.AppointmentResponse>(
                  this, METHODID_SCHEDULE_APPOINTMENT)))
          .addMethod(
            getGetAvailabilityMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                generated.grpc.AppointmentService.AvailabilityRequest,
                generated.grpc.AppointmentService.AvailabilityResponse>(
                  this, METHODID_GET_AVAILABILITY)))
          .addMethod(
            getGetAppointmentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                generated.grpc.AppointmentService.AppointmentIdRequest,
                generated.grpc.AppointmentService.AppointmentResponse>(
                  this, METHODID_GET_APPOINTMENT)))
          .build();
    }
  }

  /**
   */
  public static final class AppointmentServiceStub extends io.grpc.stub.AbstractAsyncStub<AppointmentServiceStub> {
    private AppointmentServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AppointmentServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AppointmentServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Schedules an appointment for a patient. (Unary RPC)
     * </pre>
     */
    public void scheduleAppointment(generated.grpc.AppointmentService.AppointmentRequest request,
        io.grpc.stub.StreamObserver<generated.grpc.AppointmentService.AppointmentResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getScheduleAppointmentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Streams available appointment slots for a doctor. (Server Streaming RPC)
     * </pre>
     */
    public void getAvailability(generated.grpc.AppointmentService.AvailabilityRequest request,
        io.grpc.stub.StreamObserver<generated.grpc.AppointmentService.AvailabilityResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGetAvailabilityMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Retrieves a scheduled appointment by its ID. (Unary RPC)
     * </pre>
     */
    public void getAppointment(generated.grpc.AppointmentService.AppointmentIdRequest request,
        io.grpc.stub.StreamObserver<generated.grpc.AppointmentService.AppointmentResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAppointmentMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class AppointmentServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<AppointmentServiceBlockingStub> {
    private AppointmentServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AppointmentServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AppointmentServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Schedules an appointment for a patient. (Unary RPC)
     * </pre>
     */
    public generated.grpc.AppointmentService.AppointmentResponse scheduleAppointment(generated.grpc.AppointmentService.AppointmentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getScheduleAppointmentMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Streams available appointment slots for a doctor. (Server Streaming RPC)
     * </pre>
     */
    public java.util.Iterator<generated.grpc.AppointmentService.AvailabilityResponse> getAvailability(
        generated.grpc.AppointmentService.AvailabilityRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGetAvailabilityMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Retrieves a scheduled appointment by its ID. (Unary RPC)
     * </pre>
     */
    public generated.grpc.AppointmentService.AppointmentResponse getAppointment(generated.grpc.AppointmentService.AppointmentIdRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAppointmentMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class AppointmentServiceFutureStub extends io.grpc.stub.AbstractFutureStub<AppointmentServiceFutureStub> {
    private AppointmentServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AppointmentServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AppointmentServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Schedules an appointment for a patient. (Unary RPC)
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.grpc.AppointmentService.AppointmentResponse> scheduleAppointment(
        generated.grpc.AppointmentService.AppointmentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getScheduleAppointmentMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Retrieves a scheduled appointment by its ID. (Unary RPC)
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.grpc.AppointmentService.AppointmentResponse> getAppointment(
        generated.grpc.AppointmentService.AppointmentIdRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAppointmentMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SCHEDULE_APPOINTMENT = 0;
  private static final int METHODID_GET_AVAILABILITY = 1;
  private static final int METHODID_GET_APPOINTMENT = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AppointmentServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AppointmentServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SCHEDULE_APPOINTMENT:
          serviceImpl.scheduleAppointment((generated.grpc.AppointmentService.AppointmentRequest) request,
              (io.grpc.stub.StreamObserver<generated.grpc.AppointmentService.AppointmentResponse>) responseObserver);
          break;
        case METHODID_GET_AVAILABILITY:
          serviceImpl.getAvailability((generated.grpc.AppointmentService.AvailabilityRequest) request,
              (io.grpc.stub.StreamObserver<generated.grpc.AppointmentService.AvailabilityResponse>) responseObserver);
          break;
        case METHODID_GET_APPOINTMENT:
          serviceImpl.getAppointment((generated.grpc.AppointmentService.AppointmentIdRequest) request,
              (io.grpc.stub.StreamObserver<generated.grpc.AppointmentService.AppointmentResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class AppointmentServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AppointmentServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return generated.grpc.AppointmentService.AppointmentServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AppointmentService");
    }
  }

  private static final class AppointmentServiceFileDescriptorSupplier
      extends AppointmentServiceBaseDescriptorSupplier {
    AppointmentServiceFileDescriptorSupplier() {}
  }

  private static final class AppointmentServiceMethodDescriptorSupplier
      extends AppointmentServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AppointmentServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (AppointmentServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AppointmentServiceFileDescriptorSupplier())
              .addMethod(getScheduleAppointmentMethod())
              .addMethod(getGetAvailabilityMethod())
              .addMethod(getGetAppointmentMethod())
              .build();
        }
      }
    }
    return result;
  }
}
