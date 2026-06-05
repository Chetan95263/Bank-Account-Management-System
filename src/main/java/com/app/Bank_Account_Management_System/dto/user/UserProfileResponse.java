package com.app.Bank_Account_Management_System.dto.user;

import com.app.Bank_Account_Management_System.model.AccountHolder;
import com.app.Bank_Account_Management_System.model.AccountType;
import lombok.Data;


@Data
public class UserProfileResponse {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
    private String accountNumber;
    private AccountType accountType;
    private AccountHolder accountHolder;
}
