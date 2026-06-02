package com.app.Bank_Account_Management_System.controller;

import com.app.Bank_Account_Management_System.dto.AccountHolderRequest;
import com.app.Bank_Account_Management_System.dto.AccountHolderResponse;
import com.app.Bank_Account_Management_System.service.AccountHolderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/account-holder")
public class AccountHolderController {

    private final AccountHolderService accountHolderService;

    @GetMapping("/{id}")
    public ResponseEntity<AccountHolderResponse> getAccountHolderById(@PathVariable Long id){
        AccountHolderResponse accountHolderResponse =  accountHolderService.getAccountHolderById(id);
        return ResponseEntity.ok(accountHolderResponse);
    }
    @PostMapping
    public ResponseEntity<Void> createAccount(@Valid @RequestBody AccountHolderRequest accountHolderRequest) {
        accountHolderService.createAccount(accountHolderRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
