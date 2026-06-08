package com.app.Bank_Account_Management_System.repository;

import com.app.Bank_Account_Management_System.model.AccountHolder;
import com.app.Bank_Account_Management_System.model.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount , Long> {
    Optional<BankAccount> findByAccountHolder(AccountHolder currentUserAccount);
}
