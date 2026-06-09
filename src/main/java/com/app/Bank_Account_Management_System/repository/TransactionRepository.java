package com.app.Bank_Account_Management_System.repository;

import com.app.Bank_Account_Management_System.dto.user.UserTransactionResponse;
import com.app.Bank_Account_Management_System.model.BankAccount;
import com.app.Bank_Account_Management_System.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction , Long> {
    List<Transaction> findByBankAccount(BankAccount bankAccount);
}
