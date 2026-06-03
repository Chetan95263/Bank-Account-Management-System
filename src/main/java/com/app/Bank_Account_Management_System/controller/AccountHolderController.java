package com.app.Bank_Account_Management_System.controller;

import com.app.Bank_Account_Management_System.dto.AccountHolderRequest;
import com.app.Bank_Account_Management_System.dto.AccountHolderResponse;
import com.app.Bank_Account_Management_System.service.AccountHolderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/account-holder")
public class AccountHolderController {

    private final AccountHolderService accountHolderService;

    @GetMapping("/{id}")
    public ResponseEntity<AccountHolderResponse> getAccountHolderById(@PathVariable Long id){
        return ResponseEntity.ok(accountHolderService.getAccountHolderById(id));
    }
    @GetMapping
    public ResponseEntity<List<AccountHolderResponse>> getAllAccountHolder() {
        return ResponseEntity.ok(accountHolderService.fetchALlAccountHolder());
    }
    @PostMapping
    public ResponseEntity<Void> createAccount(@Valid @RequestBody AccountHolderRequest accountHolderRequest) {
        accountHolderService.createAccount(accountHolderRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateAccount(@Valid @RequestBody AccountHolderRequest accountHolderRequest,
                                                @PathVariable Long id) {
        accountHolderService.updateAccount(id , accountHolderRequest);
        return ResponseEntity.ok("Account updated successfully");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable Long id) {
        accountHolderService.deleteAccount(id);
        return ResponseEntity.noContent().build();
    }



}
