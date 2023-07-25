package com.sevity.authservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sevity.authservice.domain.Role;
import com.sevity.authservice.domain.RoleRepository;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class AuthServiceApplication {

	public static void main(String[] args) {
        /*
        Dotenv dotenv = Dotenv.load();

        String databaseUrl = dotenv.get("DATABASE_URL");
        String databaseUsername = dotenv.get("DATABASE_USERNAME");
        String databasePassword = dotenv.get("DATABASE_PASSWORD");

        System.setProperty("spring.datasource.url", databaseUrl);
        System.setProperty("spring.datasource.username", databaseUsername);
        System.setProperty("spring.datasource.password", databasePassword);
        */
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
