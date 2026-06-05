package com.app.Bank_Account_Management_System.dto;

import com.app.Bank_Account_Management_System.model.TransactionType;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransactionRequest {
    @NotBlank(message = "Amount is required")
    private BigDecimal amount;
    @NotBlank(message = "Transaction type(e.g DEPOSIT , WITHDRAW) , is required")
    private TransactionType transactionType;
}
