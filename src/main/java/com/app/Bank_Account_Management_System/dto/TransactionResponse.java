package com.app.Bank_Account_Management_System.dto;

import com.app.Bank_Account_Management_System.model.TransactionType;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class TransactionResponse {
    private Long id;
    private BigDecimal amount;
    private TransactionType transactionType;
    private LocalDateTime transactionTime;
}
