package com.app.Bank_Account_Management_System.controller;

import com.app.Bank_Account_Management_System.dto.BankAccountRequest;
import com.app.Bank_Account_Management_System.dto.BankAccountResponse;
import com.app.Bank_Account_Management_System.service.BankAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/bank-account")
public class BankAccountController {
    private final BankAccountService bankAccountService;

    @GetMapping("/{id}")
    public ResponseEntity<BankAccountResponse> getBankAccountById(@PathVariable Long id) {
        return ResponseEntity.ok(bankAccountService.fetchById(id));
    }
    @GetMapping
    public ResponseEntity<List<BankAccountResponse>> getAllBankAccount(){
        return ResponseEntity.ok(bankAccountService.fetchAllBankAccount());
    }
    @PostMapping
    public ResponseEntity<Void> createBankAccount(@RequestBody BankAccountRequest bankAccountRequest){
        bankAccountService.createBankAccount(bankAccountRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateBankAccount(@PathVariable Long id ,@RequestBody BankAccountRequest updatedBankAccountRequest) {
        bankAccountService.updateBankAccount(id , updatedBankAccountRequest);
        return ResponseEntity.ok("Bank Account updated successfully");
    }
}
