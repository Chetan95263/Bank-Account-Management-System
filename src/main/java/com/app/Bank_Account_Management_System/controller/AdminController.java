package com.app.Bank_Account_Management_System.controller;

import com.app.Bank_Account_Management_System.dto.AddUserDTO;
import com.app.Bank_Account_Management_System.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<Void> addUser(@Valid @RequestBody AddUserDTO addUserDTO ){
        userService.addUser(addUserDTO);
        return ResponseEntity.noContent().build();
    }
}
