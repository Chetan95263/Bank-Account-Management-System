package com.app.Bank_Account_Management_System.service;

import com.app.Bank_Account_Management_System.dto.AccountHolderRequest;
import com.app.Bank_Account_Management_System.dto.AccountHolderResponse;
import com.app.Bank_Account_Management_System.model.AccountHolder;
import com.app.Bank_Account_Management_System.repository.AccountHolderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountHolderService {
    private final AccountHolderRepository accountHolderRepository;

    public AccountHolderResponse getAccountHolderById(Long id) {
        return mapToAccountHolderResponse(accountHolderRepository.getAccountHolderById(id));
    }

    public void createAccount(AccountHolderRequest accountHolderRequest) {
        AccountHolder accountHolder = new AccountHolder();
        updateUserFromRequest(accountHolder , accountHolderRequest);
        accountHolderRepository.save(accountHolder);
    }
    private void updateUserFromRequest(AccountHolder accountHolder , AccountHolderRequest accountHolderRequest) {
        accountHolder.setFirstName(accountHolderRequest.getFirstName());
        accountHolder.setLastName(accountHolderRequest.getLastName());
        accountHolder.setEmail(accountHolderRequest.getEmail());
        accountHolder.setAddress(accountHolderRequest.getAddress());
        accountHolder.setPhoneNumber(accountHolderRequest.getPhoneNumber());
        accountHolder.setAccountType(accountHolderRequest.getAccountType());
    }
    private AccountHolderResponse mapToAccountHolderResponse(AccountHolder accountHolder) {
        AccountHolderResponse response = new AccountHolderResponse();
        response.setId(accountHolder.getId());
        response.setFirstName(accountHolder.getFirstName());
        response.setLastName(accountHolder.getLastName());
        response.setEmail(accountHolder.getEmail());
        response.setPhoneNumber(accountHolder.getPhoneNumber());
        response.setAccountType(accountHolder.getAccountType());
        response.setCreatedAt(accountHolder.getCreatedAt());
        response.setUpdatedAt(accountHolder.getUpdatedAt());
        return response;
    }
}
