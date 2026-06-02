package com.app.Bank_Account_Management_System.service;

import com.app.Bank_Account_Management_System.model.AccountHolder;
import com.app.Bank_Account_Management_System.repository.AccountHolderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountHolderService {
    private final AccountHolderRepository accountHolderRepository;
    public AccountHolder getAccountHolderById(Long id) {
        return null;
    }

    public void createAccount(AccountHolder accountHolder) {
    }
}
