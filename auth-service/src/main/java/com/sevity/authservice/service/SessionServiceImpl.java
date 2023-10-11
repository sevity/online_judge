package com.sevity.authservice.service;

import com.sevity.authservice.grpc.SesseionServiceGrpc;
import com.sevity.authservice.grpc.SessionService.SessionRequest;
import com.sevity.authservice.grpc.SessionService.UserResponse;

import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import io.grpc.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.session.Session;
import org.springframework.session.SessionRepository;
import org.springframework.stereotype.Service;

import java.util.Base64;


@Service
public class SessionServiceImpl extends SesseionServiceGrpc.SesseionServiceImplBase {

    @Autowired
    private SessionRepository<? extends Session> sessionRepository;

    @Override
    public void getUserId(SessionRequest request, StreamObserver<UserResponse> responseObserver) {
        String sessionId = request.getSessionId();
        String decodedSessionId = new String(Base64.getDecoder().decode(sessionId));

        Session session = sessionRepository.findById(decodedSessionId);
        if (session == null) {
            responseObserver.onError(new StatusRuntimeException(Status.NOT_FOUND));
            return;
        }

        Long userId = session.getAttribute("userId");
        if (userId == null) {
            responseObserver.onError(new StatusRuntimeException(Status.NOT_FOUND));
            return;
        }

        UserResponse response = UserResponse.newBuilder().setUserId(userId.intValue()).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}

