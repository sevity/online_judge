//이 Rest컨트롤러는 AuthService를 주입받아 사용하며, 클라이언트의 요청을 받아, 사용자 등록과 로그인을 처리합니다.

package com.sevity.authservice.controller;

import com.sevity.authservice.domain.User;
import com.sevity.authservice.dto.UserRegistrationDto;
import com.sevity.authservice.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public User register(@RequestBody UserRegistrationDto registrationDto) {
        return authService.register(registrationDto);
    }

    @PostMapping("/login")
    public User login(@RequestBody UserRegistrationDto loginDto) {
        return authService.login(loginDto.getUsername(), loginDto.getPassword());
    }
}
