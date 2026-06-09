package com.app.Bank_Account_Management_System.dto;

import com.app.Bank_Account_Management_System.model.AccountType;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class AddUserDTO {
    // for User
    @NotBlank
    private String username;
    @NotBlank
    private String password;

    // for Account Holder
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @Email
    private String email;
    @NotBlank
    private String phoneNumber;
    @NotBlank
    private String address;

    // for Bank Account
    @NotNull
    private AccountType accountType;
}
