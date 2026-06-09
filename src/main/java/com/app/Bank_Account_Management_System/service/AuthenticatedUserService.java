package com.app.Bank_Account_Management_System.service;

import com.app.Bank_Account_Management_System.exception.ResourceNotFoundException;
import com.app.Bank_Account_Management_System.model.*;
import com.app.Bank_Account_Management_System.repository.BankAccountRepository;
import com.app.Bank_Account_Management_System.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthenticatedUserService {
    private final UserRepository userRepository;
    private final BankAccountRepository bankAccountRepository;

    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        return userRepository.findByUsername(username)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found"));
    }
    public BankAccount getCurrentUserBankAccount(){
        AccountHolder accountHolder = getCurrentUserAccountHolder();
        return bankAccountRepository.findByAccountHolder(accountHolder).orElseThrow(
                () -> new ResourceNotFoundException("Bank Account not exists")
        );
    }
    public AccountHolder getCurrentUserAccountHolder(){
        return getCurrentUser().getAccountHolder();
    }

}
