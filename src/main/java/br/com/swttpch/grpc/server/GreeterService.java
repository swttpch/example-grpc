package br.com.swttpch.grpc.server;

import br.com.swttpch.GreeterGrpc;
import br.com.swttpch.HelloRequest;
import br.com.swttpch.HelloResponse;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class GreeterService extends GreeterGrpc.GreeterImplBase {
    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloResponse> responseObserver){
        String name = request.getName();
        String message = "Hello, " + name + "!";
        HelloResponse response = HelloResponse.newBuilder().setMessage(message).build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
