package com.sevity.authservice.service;

import com.sevity.authservice.domain.User;
import com.sevity.authservice.domain.UserRepository;
import com.sevity.authservice.grpc.SesseionServiceGrpc;
import com.sevity.authservice.grpc.SessionService.SessionRequest;
import com.sevity.authservice.grpc.SessionService.UserResponse;

import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import io.grpc.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;

@Service
public class SessionServiceImpl extends SesseionServiceGrpc.SesseionServiceImplBase {

    @Autowired
    private UserRepository userRepository;
    private final StatefulRedisConnection<String, String> redisConnection;

    @Autowired
    public SessionServiceImpl(StatefulRedisConnection<String, String> redisConnection) {
        this.redisConnection = redisConnection;
    }

    @Override
    public void getUserId(SessionRequest request, StreamObserver<UserResponse> responseObserver) {
        String sessionId = request.getSessionId();

        RedisCommands<String, String> redisCommands = redisConnection.sync();
        String userId = redisCommands.get(sessionId); // Redis에서 세션 ID로 사용자 ID를 조회
        if (userId == null) {
            responseObserver.onError(new StatusRuntimeException(Status.NOT_FOUND));
            return;
        }

        // 세션 ID로 사용자 ID를 조회하는 로직
        //User user = userRepository.findBySessionId(sessionId); // 예시 코드, 실제 구현은 다를 수 있습니다.
        //String userId = user != null ? user.getId() : "Not Found";
        int nUserId = Integer.parseInt(userId);

        UserResponse response = UserResponse.newBuilder().setUserId(nUserId).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
