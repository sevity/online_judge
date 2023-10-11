package com.sevity.authservice.service;

import com.sevity.authservice.domain.User;
import com.sevity.authservice.domain.UserRepository;
import com.sevity.authservice.grpc.SesseionServiceGrpc;
import com.sevity.authservice.grpc.SessionService.SessionRequest;
import com.sevity.authservice.grpc.SessionService.UserResponse;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionServiceImpl extends SesseionServiceGrpc.SesseionServiceImplBase {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void getUserId(SessionRequest request, StreamObserver<UserResponse> responseObserver) {
        String sessionId = request.getSessionId();
        // 세션 ID로 사용자 ID를 조회하는 로직
        //User user = userRepository.findBySessionId(sessionId); // 예시 코드, 실제 구현은 다를 수 있습니다.
        //String userId = user != null ? user.getId() : "Not Found";
        int userId = 123;
        UserResponse response = UserResponse.newBuilder().setUserId(userId).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
