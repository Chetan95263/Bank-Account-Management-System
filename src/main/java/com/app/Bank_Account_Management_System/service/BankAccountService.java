package com.app.Bank_Account_Management_System.service;

import com.app.Bank_Account_Management_System.dto.BankAccountRequest;
import com.app.Bank_Account_Management_System.dto.BankAccountResponse;
import com.app.Bank_Account_Management_System.exception.ResourceNotFoundException;
import com.app.Bank_Account_Management_System.model.AccountHolder;
import com.app.Bank_Account_Management_System.model.BankAccount;
import com.app.Bank_Account_Management_System.repository.AccountHolderRepository;
import com.app.Bank_Account_Management_System.repository.BankAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BankAccountService {
    private final AccountHolderRepository accountHolderRepository;
    private final BankAccountRepository bankAccountRepository;

    public BankAccountResponse fetchById(Long id) {
        BankAccount bankAccount = bankAccountRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Bank Account not found with id: "+id)
        );
        return mapToBankAccountResponse(bankAccount);
    }

    public void createBankAccount(BankAccountRequest bankAccountRequest) {
        BankAccount bankAccount = new BankAccount();
        updateRequestToBankAccount(bankAccount , bankAccountRequest);
        bankAccount.setBalance(BigDecimal.valueOf(0));
        bankAccount.setAccountNumber(UUID.randomUUID().toString());
        AccountHolder accountHolder = accountHolderRepository.findById(bankAccountRequest.getAccountHolderId()).orElseThrow(
                () -> new ResourceNotFoundException("Account Holder not found with id: "+bankAccountRequest.getAccountHolderId())
        );
        bankAccount.setAccountHolder(accountHolder);
        bankAccountRepository.save(bankAccount);
    }

    public List<BankAccountResponse> fetchAllBankAccount() {
        return bankAccountRepository.findAll()
                .stream()
                .map(this::mapToBankAccountResponse)
                .collect(Collectors.toList());
    }
    public void updateBankAccount(Long id , BankAccountRequest request) {
        BankAccount bankAccount = bankAccountRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Bank Account not found with id: "+id)
        );
        updateRequestToBankAccount(bankAccount , request);
        bankAccountRepository.save(bankAccount);
    }
    private BankAccountResponse mapToBankAccountResponse(BankAccount bankAccount) {
        BankAccountResponse response = new BankAccountResponse();
        response.setId(bankAccount.getId());
        response.setAccountNumber(bankAccount.getAccountNumber());
        response.setAccountHolder(bankAccount.getAccountHolder());
        response.setAccountType(bankAccount.getAccountType());
        response.setBalance(bankAccount.getBalance());
        response.setCreatedAt(bankAccount.getCreatedAt());
        response.setUpdatedAt(bankAccount.getUpdatedAt());
        return response;
    }
    private void updateRequestToBankAccount(BankAccount bankAccount , BankAccountRequest request){
        bankAccount.setAccountType(request.getAccountType());
    }
}
