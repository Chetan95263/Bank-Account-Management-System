package com.app.Bank_Account_Management_System.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class BalanceDTO {
    private String accountNumber;
    private BigDecimal balance;
}
