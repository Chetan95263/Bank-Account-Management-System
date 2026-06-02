package com.app.Bank_Account_Management_System.dto;

import com.app.Bank_Account_Management_System.model.AccountType;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AccountHolderResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
    private AccountType accountType;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
