package com.app.Bank_Account_Management_System.service;

import com.app.Bank_Account_Management_System.dto.AccountHolderRequest;
import com.app.Bank_Account_Management_System.dto.AccountHolderResponse;
import com.app.Bank_Account_Management_System.exception.ResourceNotFoundException;
import com.app.Bank_Account_Management_System.model.AccountHolder;
import com.app.Bank_Account_Management_System.repository.AccountHolderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountHolderService {
    private final AccountHolderRepository accountHolderRepository;

    public AccountHolderResponse getAccountHolderById(Long id) {
        AccountHolder accountHolder = accountHolderRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Account holder not found with id: " + id)
        );
        return mapToAccountHolderResponse(accountHolder);
    }

    public void createAccount(AccountHolderRequest accountHolderRequest) {
        AccountHolder accountHolder = new AccountHolder();
        updateAccountFromRequest(accountHolder , accountHolderRequest);
        accountHolderRepository.save(accountHolder);
    }
    public List<AccountHolderResponse> fetchALlAccountHolder() {
        return accountHolderRepository.findAll()
                .stream()
                .map(this::mapToAccountHolderResponse)
                .collect(Collectors.toList());
    }
    public void updateAccount(Long id , AccountHolderRequest accountHolderRequest) {
        AccountHolder existingAccount = accountHolderRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Account holder not found with id: " + id));
        updateAccountFromRequest(existingAccount, accountHolderRequest);
        accountHolderRepository.save(existingAccount);
    }
    public void deleteAccount(Long id) {
        AccountHolder accountHolder = accountHolderRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Account holder not found with id: " + id)
        );
        accountHolderRepository.delete(accountHolder);
    }
    private void updateAccountFromRequest(AccountHolder accountHolder , AccountHolderRequest accountHolderRequest) {
        accountHolder.setFirstName(accountHolderRequest.getFirstName());
        accountHolder.setLastName(accountHolderRequest.getLastName());
        accountHolder.setEmail(accountHolderRequest.getEmail());
        accountHolder.setAddress(accountHolderRequest.getAddress());
        accountHolder.setPhoneNumber(accountHolderRequest.getPhoneNumber());

    }
    private AccountHolderResponse mapToAccountHolderResponse(AccountHolder accountHolder) {
        AccountHolderResponse response = new AccountHolderResponse();
        response.setId(accountHolder.getId());
        response.setFirstName(accountHolder.getFirstName());
        response.setLastName(accountHolder.getLastName());
        response.setEmail(accountHolder.getEmail());
        response.setPhoneNumber(accountHolder.getPhoneNumber());
        response.setCreatedAt(accountHolder.getCreatedAt());
        response.setUpdatedAt(accountHolder.getUpdatedAt());
        response.setAddress(accountHolder.getAddress());
        return response;
    }


}
