package com.app.Bank_Account_Management_System.dto.user;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BalanceDTO {
    private String accountNumber;
    private BigDecimal balance;
}
