//authentication은 Spring Security에서 제공하는 인터페이스이며, 사용자 인증에 성공하면
//인증정보를 담는다. authentication.getName()은 UserDetailsService인터페이스를 통해 결국 DB에서 
//username값을 가져오게 된다.

package com.sevity.authservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping("/user")
    public ResponseEntity<?> getUser(Authentication authentication) {
        // 이 부분에서는 인증된 사용자의 정보를 가져와서 반환하는 로직이 들어갑니다.
        return ResponseEntity.ok("User page. user: "+authentication.getName());
    }
}
