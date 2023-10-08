//AuthService 인터페이스의 구현체인 AuthServiceImpl 클래스를 작성합니다. 
//이 클래스는 AuthService 인터페이스의 메소드를 구현하며, UserRepository와 PasswordEncoder를 주입받아 사용합니다.
//웹에 접속한 사용자가 userid/password를 서버에 전달하면 db랑 매칭시켜서 등록하거나, 로그인검증하는 역할을 한다.
package com.sevity.authservice.service;

import com.sevity.authservice.controller.AuthController;
import com.sevity.authservice.domain.RoleRepository;
import com.sevity.authservice.domain.User;
import com.sevity.authservice.domain.UserRepository;
import com.sevity.authservice.dto.UserRegistrationDto;
import com.sevity.authservice.exception.UsernameAlreadyExistsException;

import java.util.Arrays;
import java.util.HashSet;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private UserRepository userRepository;
    private RoleRepository roleRepository; // Add this line
    private PasswordEncoder passwordEncoder;
        private static final Logger logger = LoggerFactory.getLogger(AuthServiceImpl.class);


    public AuthServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository; // Add this line
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User register(UserRegistrationDto registrationDto) {
        if (userRepository.existsByUsername(registrationDto.getUsername())) {
            throw new UsernameAlreadyExistsException("Username already exists: " + registrationDto.getUsername());
        }
        User user = new User();
        user.setUsername(registrationDto.getUsername());
        user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
        user.setRoles(new HashSet<>(Arrays.asList(roleRepository.findByName("ROLE_USER"))));
        return userRepository.save(user);
    }

/*
    @Override
    public User login(String username, String password) {
        logger.info("Login attempt for username: {}", username);

        User user = userRepository.findByUsername(username);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            // 세션 생성
            //HttpSession session = request.getSession();
            //session.setAttribute("user", user);
            return user;
        } else {
            return null;
        }
    }
*/    
}
