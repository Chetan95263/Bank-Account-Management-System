package com.app.Bank_Account_Management_System.dto;

import com.app.Bank_Account_Management_System.model.AccountHolder;
import com.app.Bank_Account_Management_System.model.AccountType;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BankAccountResponse {
    private Long id;
    private String accountNumber;
    private Double balance;
    private AccountType accountType;
    private AccountHolder accountHolder;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
