package com.app.Bank_Account_Management_System.service;

import com.app.Bank_Account_Management_System.dto.AddUserDTO;
import com.app.Bank_Account_Management_System.dto.user.UserProfileResponse;
import com.app.Bank_Account_Management_System.model.AccountHolder;
import com.app.Bank_Account_Management_System.model.BankAccount;
import com.app.Bank_Account_Management_System.model.Role;
import com.app.Bank_Account_Management_System.model.User;
import com.app.Bank_Account_Management_System.repository.AccountHolderRepository;
import com.app.Bank_Account_Management_System.repository.BankAccountRepository;
import com.app.Bank_Account_Management_System.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final AuthenticatedUserService authenticatedUserService;
    private final PasswordEncoder passwordEncoder;
    private final BankAccountService bankAccountService;
    private final AccountHolderRepository accountHolderRepository;
    private final BankAccountRepository bankAccountRepository;

    public UserProfileResponse getUserProfile(){
        AccountHolder accountHolder = authenticatedUserService.getCurrentUserAccountHolder();
        BankAccount bankAccount = authenticatedUserService.getCurrentUserBankAccount();
        return UserProfileResponse.builder()
                .firstName(accountHolder.getFirstName())
                .lastName(accountHolder.getLastName())
                .email(accountHolder.getEmail())
                .address(accountHolder.getAddress())
                .phoneNumber(accountHolder.getPhoneNumber())
                .accountType(bankAccount.getAccountType())
                .accountNumber(bankAccount.getAccountNumber())
                .build();
    }
    @Transactional
    public void addUser(AddUserDTO addUserDTO) {
        // Creating AccountHolder
        AccountHolder accountHolder = createAccountHolder(addUserDTO);
        // Creating User
        User user = createUser(addUserDTO , accountHolder);
        // Creating BankAccount
        BankAccount bankAccount = createBankAccount(addUserDTO , accountHolder);
        // Saving data
        saveUserData(accountHolder , bankAccount , user);
    }


    private String generateAccountNumber(){
        final long MIN_11_DIGIT = 10000000000L;
        final long MAX_11_DIGIT = 99999999999L;
        String accountNumber;

        do {
            long num = ThreadLocalRandom.current().nextLong(MIN_11_DIGIT, MAX_11_DIGIT + 1);
            accountNumber = String.valueOf(num);
        } while(bankAccountService.isAccountNumberExists(accountNumber));

        return accountNumber;
    }
    private AccountHolder createAccountHolder(AddUserDTO dto) {
        // creating AccountHolder
        AccountHolder accountHolder = new AccountHolder();
        accountHolder.setFirstName(dto.getFirstName());
        accountHolder.setLastName(dto.getLastName());
        accountHolder.setEmail(dto.getEmail());
        accountHolder.setAddress(dto.getAddress());
        accountHolder.setPhoneNumber(dto.getPhoneNumber());

        return accountHolder;
    }
    private User createUser(AddUserDTO dto, AccountHolder accountHolder) {
        // creating User
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setRole(Role.USER);
        user.setAccountHolder(accountHolder);

        return user;
    }
    private BankAccount createBankAccount(AddUserDTO dto, AccountHolder accountHolder) {
        // creating BankAccount
        BankAccount bankAccount = new BankAccount();
        bankAccount.setAccountNumber(generateAccountNumber());
        bankAccount.setAccountType(dto.getAccountType());
        bankAccount.setBalance(BigDecimal.ZERO);
        bankAccount.setAccountHolder(accountHolder);

        return bankAccount;
    }
    private void saveUserData(AccountHolder accountHolder, BankAccount bankAccount, User user) {
        // Saving Data
        accountHolderRepository.save(accountHolder);
        bankAccountRepository.save(bankAccount);
        userRepository.save(user);
    }

}
