package com.app.Bank_Account_Management_System.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AccountHolderRequest {
    @NotBlank(message = "First name is required")
    private String firstName;

    @NotBlank(message = "Last name is required")
    private String lastName;

    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Phone number is required")
    private String phoneNumber;

    @NotBlank(message = "Address is required")
    private String address;
}
