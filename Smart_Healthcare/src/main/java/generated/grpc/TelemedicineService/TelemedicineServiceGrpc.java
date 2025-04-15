package generated.grpc.TelemedicineService;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.52.1)",
    comments = "Source: TelemedicineService.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class TelemedicineServiceGrpc {

  private TelemedicineServiceGrpc() {}

  public static final String SERVICE_NAME = "TelemedicineService.TelemedicineService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<generated.grpc.TelemedicineService.ConsultationRequest,
      generated.grpc.TelemedicineService.ConsultationResponse> getStartConsultationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StartConsultation",
      requestType = generated.grpc.TelemedicineService.ConsultationRequest.class,
      responseType = generated.grpc.TelemedicineService.ConsultationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.grpc.TelemedicineService.ConsultationRequest,
      generated.grpc.TelemedicineService.ConsultationResponse> getStartConsultationMethod() {
    io.grpc.MethodDescriptor<generated.grpc.TelemedicineService.ConsultationRequest, generated.grpc.TelemedicineService.ConsultationResponse> getStartConsultationMethod;
    if ((getStartConsultationMethod = TelemedicineServiceGrpc.getStartConsultationMethod) == null) {
      synchronized (TelemedicineServiceGrpc.class) {
        if ((getStartConsultationMethod = TelemedicineServiceGrpc.getStartConsultationMethod) == null) {
          TelemedicineServiceGrpc.getStartConsultationMethod = getStartConsultationMethod =
              io.grpc.MethodDescriptor.<generated.grpc.TelemedicineService.ConsultationRequest, generated.grpc.TelemedicineService.ConsultationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StartConsultation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.grpc.TelemedicineService.ConsultationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.grpc.TelemedicineService.ConsultationResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TelemedicineServiceMethodDescriptorSupplier("StartConsultation"))
              .build();
        }
      }
    }
    return getStartConsultationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<generated.grpc.TelemedicineService.MessageRequest,
      generated.grpc.TelemedicineService.MessageResponse> getChatMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Chat",
      requestType = generated.grpc.TelemedicineService.MessageRequest.class,
      responseType = generated.grpc.TelemedicineService.MessageResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<generated.grpc.TelemedicineService.MessageRequest,
      generated.grpc.TelemedicineService.MessageResponse> getChatMethod() {
    io.grpc.MethodDescriptor<generated.grpc.TelemedicineService.MessageRequest, generated.grpc.TelemedicineService.MessageResponse> getChatMethod;
    if ((getChatMethod = TelemedicineServiceGrpc.getChatMethod) == null) {
      synchronized (TelemedicineServiceGrpc.class) {
        if ((getChatMethod = TelemedicineServiceGrpc.getChatMethod) == null) {
          TelemedicineServiceGrpc.getChatMethod = getChatMethod =
              io.grpc.MethodDescriptor.<generated.grpc.TelemedicineService.MessageRequest, generated.grpc.TelemedicineService.MessageResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Chat"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.grpc.TelemedicineService.MessageRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.grpc.TelemedicineService.MessageResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TelemedicineServiceMethodDescriptorSupplier("Chat"))
              .build();
        }
      }
    }
    return getChatMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TelemedicineServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TelemedicineServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TelemedicineServiceStub>() {
        @java.lang.Override
        public TelemedicineServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TelemedicineServiceStub(channel, callOptions);
        }
      };
    return TelemedicineServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TelemedicineServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TelemedicineServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TelemedicineServiceBlockingStub>() {
        @java.lang.Override
        public TelemedicineServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TelemedicineServiceBlockingStub(channel, callOptions);
        }
      };
    return TelemedicineServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TelemedicineServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TelemedicineServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TelemedicineServiceFutureStub>() {
        @java.lang.Override
        public TelemedicineServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TelemedicineServiceFutureStub(channel, callOptions);
        }
      };
    return TelemedicineServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class TelemedicineServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Starts a virtual consultation between a patient and a doctor. (Unary RPC)
     * </pre>
     */
    public void startConsultation(generated.grpc.TelemedicineService.ConsultationRequest request,
        io.grpc.stub.StreamObserver<generated.grpc.TelemedicineService.ConsultationResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStartConsultationMethod(), responseObserver);
    }

    /**
     * <pre>
     * Supports real-time chat between a patient and a doctor. (Bidirectional Streaming RPC)
     * </pre>
     */
    public io.grpc.stub.StreamObserver<generated.grpc.TelemedicineService.MessageRequest> chat(
        io.grpc.stub.StreamObserver<generated.grpc.TelemedicineService.MessageResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getChatMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getStartConsultationMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                generated.grpc.TelemedicineService.ConsultationRequest,
                generated.grpc.TelemedicineService.ConsultationResponse>(
                  this, METHODID_START_CONSULTATION)))
          .addMethod(
            getChatMethod(),
            io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
              new MethodHandlers<
                generated.grpc.TelemedicineService.MessageRequest,
                generated.grpc.TelemedicineService.MessageResponse>(
                  this, METHODID_CHAT)))
          .build();
    }
  }

  /**
   */
  public static final class TelemedicineServiceStub extends io.grpc.stub.AbstractAsyncStub<TelemedicineServiceStub> {
    private TelemedicineServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TelemedicineServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TelemedicineServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Starts a virtual consultation between a patient and a doctor. (Unary RPC)
     * </pre>
     */
    public void startConsultation(generated.grpc.TelemedicineService.ConsultationRequest request,
        io.grpc.stub.StreamObserver<generated.grpc.TelemedicineService.ConsultationResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStartConsultationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Supports real-time chat between a patient and a doctor. (Bidirectional Streaming RPC)
     * </pre>
     */
    public io.grpc.stub.StreamObserver<generated.grpc.TelemedicineService.MessageRequest> chat(
        io.grpc.stub.StreamObserver<generated.grpc.TelemedicineService.MessageResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getChatMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class TelemedicineServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<TelemedicineServiceBlockingStub> {
    private TelemedicineServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TelemedicineServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TelemedicineServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Starts a virtual consultation between a patient and a doctor. (Unary RPC)
     * </pre>
     */
    public generated.grpc.TelemedicineService.ConsultationResponse startConsultation(generated.grpc.TelemedicineService.ConsultationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStartConsultationMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class TelemedicineServiceFutureStub extends io.grpc.stub.AbstractFutureStub<TelemedicineServiceFutureStub> {
    private TelemedicineServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TelemedicineServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TelemedicineServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Starts a virtual consultation between a patient and a doctor. (Unary RPC)
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.grpc.TelemedicineService.ConsultationResponse> startConsultation(
        generated.grpc.TelemedicineService.ConsultationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStartConsultationMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_START_CONSULTATION = 0;
  private static final int METHODID_CHAT = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TelemedicineServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TelemedicineServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_START_CONSULTATION:
          serviceImpl.startConsultation((generated.grpc.TelemedicineService.ConsultationRequest) request,
              (io.grpc.stub.StreamObserver<generated.grpc.TelemedicineService.ConsultationResponse>) responseObserver);
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
        case METHODID_CHAT:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.chat(
              (io.grpc.stub.StreamObserver<generated.grpc.TelemedicineService.MessageResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class TelemedicineServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TelemedicineServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return generated.grpc.TelemedicineService.TelemedicineServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TelemedicineService");
    }
  }

  private static final class TelemedicineServiceFileDescriptorSupplier
      extends TelemedicineServiceBaseDescriptorSupplier {
    TelemedicineServiceFileDescriptorSupplier() {}
  }

  private static final class TelemedicineServiceMethodDescriptorSupplier
      extends TelemedicineServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TelemedicineServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (TelemedicineServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TelemedicineServiceFileDescriptorSupplier())
              .addMethod(getStartConsultationMethod())
              .addMethod(getChatMethod())
              .build();
        }
      }
    }
    return result;
  }
}
