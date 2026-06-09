package com.app.Bank_Account_Management_System.security;

import com.app.Bank_Account_Management_System.dto.LoginRequest;
import com.app.Bank_Account_Management_System.dto.LoginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public LoginResponse login(LoginRequest request) {
            Authentication authentication = authenticationManager.authenticate(
                                    new UsernamePasswordAuthenticationToken(
                                            request.getUsername(),
                                            request.getPassword()
                                    )
                            );

            UserDetails user = (UserDetails) authentication.getPrincipal();
            String token = jwtService.generateToken(user);
            return new LoginResponse(token);
    }
}