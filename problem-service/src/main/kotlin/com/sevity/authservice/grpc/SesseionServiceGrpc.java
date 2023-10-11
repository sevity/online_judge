package com.sevity.authservice.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.58.0)",
    comments = "Source: session_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class SesseionServiceGrpc {

  private SesseionServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "com.sevity.authservice.grpc.SesseionService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.sevity.authservice.grpc.SessionService.SessionRequest,
      com.sevity.authservice.grpc.SessionService.UserResponse> getGetUserIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetUserId",
      requestType = com.sevity.authservice.grpc.SessionService.SessionRequest.class,
      responseType = com.sevity.authservice.grpc.SessionService.UserResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.sevity.authservice.grpc.SessionService.SessionRequest,
      com.sevity.authservice.grpc.SessionService.UserResponse> getGetUserIdMethod() {
    io.grpc.MethodDescriptor<com.sevity.authservice.grpc.SessionService.SessionRequest, com.sevity.authservice.grpc.SessionService.UserResponse> getGetUserIdMethod;
    if ((getGetUserIdMethod = SesseionServiceGrpc.getGetUserIdMethod) == null) {
      synchronized (SesseionServiceGrpc.class) {
        if ((getGetUserIdMethod = SesseionServiceGrpc.getGetUserIdMethod) == null) {
          SesseionServiceGrpc.getGetUserIdMethod = getGetUserIdMethod =
              io.grpc.MethodDescriptor.<com.sevity.authservice.grpc.SessionService.SessionRequest, com.sevity.authservice.grpc.SessionService.UserResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetUserId"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.sevity.authservice.grpc.SessionService.SessionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.sevity.authservice.grpc.SessionService.UserResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SesseionServiceMethodDescriptorSupplier("GetUserId"))
              .build();
        }
      }
    }
    return getGetUserIdMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SesseionServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SesseionServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SesseionServiceStub>() {
        @java.lang.Override
        public SesseionServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SesseionServiceStub(channel, callOptions);
        }
      };
    return SesseionServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SesseionServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SesseionServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SesseionServiceBlockingStub>() {
        @java.lang.Override
        public SesseionServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SesseionServiceBlockingStub(channel, callOptions);
        }
      };
    return SesseionServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SesseionServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SesseionServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SesseionServiceFutureStub>() {
        @java.lang.Override
        public SesseionServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SesseionServiceFutureStub(channel, callOptions);
        }
      };
    return SesseionServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void getUserId(com.sevity.authservice.grpc.SessionService.SessionRequest request,
        io.grpc.stub.StreamObserver<com.sevity.authservice.grpc.SessionService.UserResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetUserIdMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service SesseionService.
   */
  public static abstract class SesseionServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return SesseionServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service SesseionService.
   */
  public static final class SesseionServiceStub
      extends io.grpc.stub.AbstractAsyncStub<SesseionServiceStub> {
    private SesseionServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SesseionServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SesseionServiceStub(channel, callOptions);
    }

    /**
     */
    public void getUserId(com.sevity.authservice.grpc.SessionService.SessionRequest request,
        io.grpc.stub.StreamObserver<com.sevity.authservice.grpc.SessionService.UserResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetUserIdMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service SesseionService.
   */
  public static final class SesseionServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<SesseionServiceBlockingStub> {
    private SesseionServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SesseionServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SesseionServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.sevity.authservice.grpc.SessionService.UserResponse getUserId(com.sevity.authservice.grpc.SessionService.SessionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetUserIdMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service SesseionService.
   */
  public static final class SesseionServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<SesseionServiceFutureStub> {
    private SesseionServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SesseionServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SesseionServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.sevity.authservice.grpc.SessionService.UserResponse> getUserId(
        com.sevity.authservice.grpc.SessionService.SessionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetUserIdMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_USER_ID = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_USER_ID:
          serviceImpl.getUserId((com.sevity.authservice.grpc.SessionService.SessionRequest) request,
              (io.grpc.stub.StreamObserver<com.sevity.authservice.grpc.SessionService.UserResponse>) responseObserver);
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

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getGetUserIdMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.sevity.authservice.grpc.SessionService.SessionRequest,
              com.sevity.authservice.grpc.SessionService.UserResponse>(
                service, METHODID_GET_USER_ID)))
        .build();
  }

  private static abstract class SesseionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SesseionServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.sevity.authservice.grpc.SessionService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SesseionService");
    }
  }

  private static final class SesseionServiceFileDescriptorSupplier
      extends SesseionServiceBaseDescriptorSupplier {
    SesseionServiceFileDescriptorSupplier() {}
  }

  private static final class SesseionServiceMethodDescriptorSupplier
      extends SesseionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    SesseionServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (SesseionServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SesseionServiceFileDescriptorSupplier())
              .addMethod(getGetUserIdMethod())
              .build();
        }
      }
    }
    return result;
  }
}
