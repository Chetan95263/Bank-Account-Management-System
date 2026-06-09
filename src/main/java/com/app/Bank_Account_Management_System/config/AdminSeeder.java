package com.app.Bank_Account_Management_System.config;

import com.app.Bank_Account_Management_System.model.Role;
import com.app.Bank_Account_Management_System.model.User;
import com.app.Bank_Account_Management_System.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AdminSeeder implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        String adminUsername = "admin";

        if (userRepository.findByUsername(adminUsername).isEmpty()) {
            User admin = User.builder()
                    .username(adminUsername)
                    .password(passwordEncoder.encode("admin123"))
                    .role(Role.ADMIN)
                    .build();
            userRepository.save(admin);
        }
    }
}