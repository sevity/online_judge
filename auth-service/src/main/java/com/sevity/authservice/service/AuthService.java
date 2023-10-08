//이 인터페이스는 사용자 등록과 로그인 기능을 정의합니다.
package com.sevity.authservice.service;

import com.sevity.authservice.domain.User;
import com.sevity.authservice.dto.UserRegistrationDto;

public interface AuthService {
    User register(UserRegistrationDto registrationDto);
    //User login(String username, String password);
}
