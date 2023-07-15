package com.sevity.authservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sevity.authservice.domain.Role;
import com.sevity.authservice.domain.RoleRepository;

@SpringBootApplication
public class AuthServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthServiceApplication.class, args);
	}
	
	@Bean
    CommandLineRunner init(RoleRepository roleRepository) {
        return args -> {
            Role adminRole = roleRepository.findByName("ROLE_ADMIN");
            if (adminRole == null) {
                Role newAdminRole = new Role();
                newAdminRole.setName("ROLE_ADMIN");
                roleRepository.save(newAdminRole);
            }
            
            Role userRole = roleRepository.findByName("ROLE_USER");
            if (userRole == null) {
                Role newUserRole = new Role();
                newUserRole.setName("ROLE_USER");
                roleRepository.save(newUserRole);
            }
        };
    }
}
