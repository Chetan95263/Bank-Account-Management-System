package com.app.Bank_Account_Management_System.dto;

import com.app.Bank_Account_Management_System.model.AccountType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BankAccountRequest {

    @NotBlank(message = "AccountHolder id is required!")
    private Long accountHolderId;

    @NotNull(message = "Account type is required")
    private AccountType accountType;

}
