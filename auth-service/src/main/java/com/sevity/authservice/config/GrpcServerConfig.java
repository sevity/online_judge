package com.sevity.authservice.config;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import com.sevity.authservice.service.SessionServiceImpl;
import io.lettuce.core.api.StatefulRedisConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Configuration
public class GrpcServerConfig {
    private static final Logger logger = LoggerFactory.getLogger(GrpcServerConfig.class);


    @Autowired
    private SessionServiceImpl sessionService;

    private Server server;
    
    @Value("${grpc.server.port}")
    private int port;

    @PostConstruct
    public void startServer() throws IOException {
        server = ServerBuilder
            .forPort(port)
            .addService(sessionService)  // Your gRPC service implementation
            .build();

        server.start();
        logger.info("sevity gRPC server started on port {}", port);
        logger.info("sevity gRPC service name: {}", sessionService.getClass().getSimpleName());        
    }

    @PreDestroy
    public void stopServer() {
        if (server != null) {
            server.shutdown();
        }
        logger.info("sevity gRPC server stopped");
    }
}
