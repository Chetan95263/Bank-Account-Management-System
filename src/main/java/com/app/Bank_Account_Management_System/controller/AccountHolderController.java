package com.app.Bank_Account_Management_System.controller;

import com.app.Bank_Account_Management_System.model.AccountHolder;
import com.app.Bank_Account_Management_System.service.AccountHolderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/account-holder")
public class AccountHolderController {

    private final AccountHolderService accountHolderService;


}
