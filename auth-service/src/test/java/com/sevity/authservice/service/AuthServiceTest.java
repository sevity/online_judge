package com.sevity.authservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.sevity.authservice.domain.User;
import com.sevity.authservice.dto.UserRegistrationDto;
import com.sevity.authservice.exception.UsernameAlreadyExistsException;

@SpringBootTest
class AuthServiceTest {

    @Autowired
    private AuthService authService;

    @Autowired
    private PasswordEncoder passwordEncoder; // add this line

    // Test cases will go here
    @BeforeAll
    static void beforeAll() {
        System.out.println("sevity beforeAll");
    }
    
    @BeforeEach
    public void beforeEach() {
        System.out.println("sevity beforeEach called!");
    }

    @DisplayName("register 기본테스트")
    @Test
    void registerShouldCreateNewUser() {
        UserRegistrationDto newUser = new UserRegistrationDto("test_user2", "testpassword");
        User registeredUser = authService.register(newUser);

        assertNotNull(registeredUser);
        assertEquals("test_user2", registeredUser.getUsername());
        assertTrue(passwordEncoder.matches("testpassword", registeredUser.getPassword()));
    }

    @DisplayName("중복 register 테스트")
    @Test
    void registerShouldFailWhenUsernameAlreadyExists() {
        UserRegistrationDto newUser = new UserRegistrationDto("test_user3", "password");
        authService.register(newUser);
        assertNotNull(newUser);

        UserRegistrationDto duplicateUser = new UserRegistrationDto("test_user3", "password");
        assertThrows(UsernameAlreadyExistsException.class, () -> authService.register(duplicateUser));
    }

}
