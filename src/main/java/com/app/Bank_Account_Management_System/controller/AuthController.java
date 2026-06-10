package com.app.Bank_Account_Management_System.controller;

import com.app.Bank_Account_Management_System.dto.LoginRequest;
import com.app.Bank_Account_Management_System.dto.LoginResponse;
import com.app.Bank_Account_Management_System.security.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> loginUser(@Valid @RequestBody LoginRequest loginDTO) {
        return ResponseEntity.ok(authService.login(loginDTO));
    }
}