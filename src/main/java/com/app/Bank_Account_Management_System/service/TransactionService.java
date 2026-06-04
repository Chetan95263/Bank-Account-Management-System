package com.app.Bank_Account_Management_System.service;

import com.app.Bank_Account_Management_System.dto.TransactionRequest;
import com.app.Bank_Account_Management_System.dto.TransactionResponse;
import com.app.Bank_Account_Management_System.exception.InsufficientBalanceException;
import com.app.Bank_Account_Management_System.exception.ResourceNotFoundException;
import com.app.Bank_Account_Management_System.model.BankAccount;
import com.app.Bank_Account_Management_System.model.Transaction;
import com.app.Bank_Account_Management_System.model.TransactionType;
import com.app.Bank_Account_Management_System.repository.BankAccountRepository;
import com.app.Bank_Account_Management_System.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final BankAccountRepository bankAccountRepository;
    private final TransactionRepository transactionRepository;

    public TransactionResponse fetchTransactionById(Long id) {
        Transaction transaction = transactionRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Transaction not found with id: "+id)
        );
        return mapToTransactionResponse(transaction);
    }

    public List<TransactionResponse> getAllTransaction() {
        return transactionRepository.findAll()
                .stream()
                .map(this::mapToTransactionResponse)
                .collect(Collectors.toList());
    }

    public void createTransaction(TransactionRequest request) {
        Transaction transaction = new Transaction();
        updateRequestToTransaction(transaction , request);
        BankAccount bankAccount = bankAccountRepository.findById(request.getBankAccountId()).orElseThrow(
                () -> new ResourceNotFoundException("Bank Account not found with id: "+request.getBankAccountId())
        );
        transaction.setBankAccount(bankAccount);
        if(transaction.getTransactionType() == TransactionType.DEPOSIT) {
            bankAccount.setBalance(bankAccount.getBalance().add(transaction.getAmount()));
        } else {
            if(bankAccount.getBalance().compareTo(transaction.getAmount()) < 0) throw new InsufficientBalanceException("Insufficient balance for withdrawal");
            bankAccount.setBalance(bankAccount.getBalance().subtract(transaction.getAmount()));
        }
        bankAccountRepository.save(bankAccount);
        transactionRepository.save(transaction);
    }
    private TransactionResponse mapToTransactionResponse(Transaction transaction) {
        TransactionResponse transactionResponse = new TransactionResponse();
        transactionResponse.setId(transaction.getId());
        transactionResponse.setTransactionTime(transaction.getTransactionTime());
        transactionResponse.setTransactionType(transaction.getTransactionType());
        transactionResponse.setAmount(transaction.getAmount());
        return transactionResponse;
    }
    private void updateRequestToTransaction(Transaction transaction , TransactionRequest request) {
        transaction.setAmount(request.getAmount());
        transaction.setTransactionType(request.getTransactionType());
    }
}
