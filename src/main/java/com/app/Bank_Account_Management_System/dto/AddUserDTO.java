package com.app.Bank_Account_Management_System.dto;

import com.app.Bank_Account_Management_System.model.AccountType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class AddUserDTO {
    // for User
    @NotBlank(message =  "username is required!")
    private String username;
    @NotBlank(message =  "password is required!")
    private String password;

    // for Account Holder
    @NotBlank(message =  "firstName is required!")
    private String firstName;
    @NotBlank(message =  "lastName is required!")
    private String lastName;

    @NotBlank(message = "email is required!")
    private String email;
    @NotBlank(message =  "phoneNumber is required!")
    private String phoneNumber;
    @NotBlank(message =  "address is required!")
    private String address;

    // for Bank Account
    @NotNull(message =  "AccountType is required! (e.g SAVINGS , Fixed_Deposit , CURRENT")
    private AccountType accountType;
}
