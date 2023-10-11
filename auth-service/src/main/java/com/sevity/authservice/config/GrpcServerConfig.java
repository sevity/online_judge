package com.sevity.authservice.config;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

import org.springframework.context.annotation.Configuration;

import com.sevity.authservice.service.SessionServiceImpl;

@Configuration
public class GrpcServerConfig {

    public GrpcServerConfig() throws IOException{
        Server server = ServerBuilder.forPort(50051)
            .addService(new SessionServiceImpl())  // Your gRPC service implementation
            .build();

        server.start();
    }
}
