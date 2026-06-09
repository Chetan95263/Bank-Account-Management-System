package com.app.Bank_Account_Management_System.controller;

import com.app.Bank_Account_Management_System.dto.MessageDTO;
import com.app.Bank_Account_Management_System.dto.TransactionRequest;
import com.app.Bank_Account_Management_System.dto.user.BalanceDTO;
import com.app.Bank_Account_Management_System.dto.user.UserProfileResponse;
import com.app.Bank_Account_Management_System.dto.user.UserTransactionResponse;
import com.app.Bank_Account_Management_System.service.BankAccountService;
import com.app.Bank_Account_Management_System.service.TransactionService;
import com.app.Bank_Account_Management_System.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final BankAccountService bankAccountService;
    private final TransactionService transactionService;
    private final UserService userService;

    @GetMapping("/balance")
    public ResponseEntity<BalanceDTO> getBalance() {
        return ResponseEntity.ok(bankAccountService.getBalance());
    }
    @GetMapping("/transaction")
    public ResponseEntity<List<UserTransactionResponse>> getTransactions() {
        return ResponseEntity.ok(transactionService.getAllTransactions());
    }
    @GetMapping("/profile")
    public ResponseEntity<UserProfileResponse> getProfile() {
        return ResponseEntity.ok(userService.getUserProfile());
    }
    @PostMapping("/transaction")
    public ResponseEntity<MessageDTO> processTransaction(@RequestBody TransactionRequest transactionRequest) {
        transactionService.performTransaction(transactionRequest);
        return ResponseEntity.ok(new MessageDTO("Transaction successfully completed!"));
    }
}
