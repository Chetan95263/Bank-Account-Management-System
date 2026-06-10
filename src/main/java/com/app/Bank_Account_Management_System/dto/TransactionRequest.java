package com.app.Bank_Account_Management_System.dto;

import com.app.Bank_Account_Management_System.model.TransactionType;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransactionRequest {
    @NotNull(message = "Amount is required")
    @DecimalMin(value = "100", message = "Amount must be greater than or equal to 100")
    private BigDecimal amount;
    @NotNull(message = "Transaction type(e.g DEPOSIT , WITHDRAW) , is required")
    private TransactionType transactionType;
}
