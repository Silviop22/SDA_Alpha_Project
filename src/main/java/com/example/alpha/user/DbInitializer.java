package com.example.alpha.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DbInitializer {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DbInitializer(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    public CommandLineRunner initDatabase() {
        return args -> {
            User admin = new User();
            admin.setName("Admin");
            admin.setLastName("User");
            admin.setEmail("admin@example.com");
            admin.setPassword(passwordEncoder.encode("admin"));
            admin.setRoles(Arrays.asList(Role.ADMIN));

            User user = new User();
            user.setName("Regular");
            user.setLastName("User");
            user.setEmail("user@example.com");
            user.setPassword(passwordEncoder.encode("user"));
            user.setRoles(Arrays.asList(Role.USER));

            // Save to database
            userRepository.save(admin);
            userRepository.save(user);
        };
    }
}