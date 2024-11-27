package com.example.accountapi.service;

import com.example.accountapi.dto.AccountCreationRequest;
import com.example.accountapi.model.Account;
import com.example.accountapi.model.Transaction;
import com.example.accountapi.model.User;
import com.example.accountapi.repository.AccountRepository;
import com.example.accountapi.repository.TransactionRepository;
import com.example.accountapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AccountService {

    private final UserRepository userRepository;
    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    @Autowired
    public AccountService(UserRepository userRepository, AccountRepository accountRepository, TransactionRepository transactionRepository) {
        this.userRepository = userRepository;
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    public String openAccount(Long customerId, double initialCredit) {
        // Check if the user exists
        User user = userRepository.findById(customerId);
        if (user == null) {
            return "User not found.";
        }

        // Create a new account for the user
        Account newAccount = new Account();
        newAccount.setUserId(customerId);
        newAccount.setBalance(initialCredit);
        accountRepository.save(newAccount);  // Save account in the in-memory repository

        // If initial credit is greater than 0, create a transaction
        if (initialCredit > 0) {
            Transaction transaction = new Transaction();
            transaction.setAccountId(newAccount.getAccountId());
            transaction.setAmount(initialCredit);
            transaction.setTransactionDate(LocalDateTime.now());

            transactionRepository.save(transaction);  // Save transaction in the in-memory repository
            newAccount.getTransactions().add(transaction);  // Link transaction to the account
        }

        user.getAccounts().add(newAccount);  // Link account to the user
        return "Account successfully opened for user ID: " + customerId;
    }
}
