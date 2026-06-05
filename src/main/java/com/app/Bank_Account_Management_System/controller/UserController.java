package com.app.Bank_Account_Management_System.controller;

import com.app.Bank_Account_Management_System.dto.MessageDTO;
import com.app.Bank_Account_Management_System.dto.TransactionRequest;
import com.app.Bank_Account_Management_System.dto.user.BalanceDTO;
import com.app.Bank_Account_Management_System.dto.user.UserProfileResponse;
import com.app.Bank_Account_Management_System.dto.user.UserTransactionResponse;
import com.app.Bank_Account_Management_System.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping("/balance")
    public ResponseEntity<BalanceDTO> getBalance() {
        return ResponseEntity.ok().build();
    }
    public ResponseEntity<List<UserTransactionResponse>> getTransactions() {
        return ResponseEntity.ok().build();
    }
    @GetMapping("/profile")
    public ResponseEntity<UserProfileResponse> getProfile() {
        return ResponseEntity.ok().build();
    }
    @PostMapping
    public ResponseEntity<MessageDTO> processTransaction(@RequestBody TransactionRequest transactionRequest) {
        return ResponseEntity.ok().build();
    }


}
