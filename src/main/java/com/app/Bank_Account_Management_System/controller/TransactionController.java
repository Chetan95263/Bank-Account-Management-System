package com.app.Bank_Account_Management_System.controller;

import com.app.Bank_Account_Management_System.dto.TransactionRequest;
import com.app.Bank_Account_Management_System.dto.TransactionResponse;
import com.app.Bank_Account_Management_System.service.TransactionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin/transaction")
@PreAuthorize("hasRole('ADMIN')")
public class TransactionController {
    private final TransactionService transactionService;
    @GetMapping("/{id}")
    public ResponseEntity<TransactionResponse> getTransactionById(@PathVariable Long id) {
        return ResponseEntity.ok(transactionService.fetchTransactionById(id));
    }
    @GetMapping
    public ResponseEntity<List<TransactionResponse>> getAllTransaction() {
        return ResponseEntity.ok(transactionService.getAllTransaction());
    }

    @PostMapping
    public ResponseEntity<Void> createTransaction(@Valid @RequestBody TransactionRequest request) {
        transactionService.performTransaction(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
