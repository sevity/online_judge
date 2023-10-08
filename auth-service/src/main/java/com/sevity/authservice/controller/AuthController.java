//이 Rest컨트롤러는 AuthService를 주입받아 사용하며, 클라이언트의 요청을 받아, 사용자 등록과 로그인을 처리합니다.

package com.sevity.authservice.controller;

import com.sevity.authservice.domain.User;
import com.sevity.authservice.dto.UserRegistrationDto;
import com.sevity.authservice.service.AuthService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin(origins = "http://sevity.com:9992", allowCredentials = "true")
public class AuthController {

    private AuthService authService;
    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);


    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public User register(@RequestBody UserRegistrationDto registrationDto) {
        return authService.register(registrationDto);
    }

    @PostMapping("/login")
    public User login(@RequestBody UserRegistrationDto loginDto) {
        logger.info("Login attempt for username: {}", loginDto.getUsername());
        return null;
        //return authService.login(loginDto.getUsername(), loginDto.getPassword());
    }
    
    @GetMapping("/api/session/status")
    public ResponseEntity<?> sessionStatus(HttpServletRequest request) {
        logger.info("sevity log!");
        HttpSession session = request.getSession(false);
        //HttpSession session = request.getSession();  // 이거 하면 (같은 사이트 기준) 쿠키기록은 되지만 세션을 새로 만들어 버린다 ㅠ
        if (session != null) {
            // 세션이 존재하면, 세션 정보를 반환
            return ResponseEntity.ok(session.getId());
        } else {
            // 세션이 존재하지 않으면, 세션 없음을 반환
            return ResponseEntity.ok("");
        }
    }
}
