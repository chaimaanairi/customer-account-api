package com.example.accountapi.repository;

import com.example.accountapi.model.Transaction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TransactionRepository {
    private final List<Transaction> transactions = new ArrayList<>();

    public void save(Transaction transaction) {
        transactions.add(transaction);
    }

    public List<Transaction> findAllByAccountId(Long accountId) {
        List<Transaction> accountTransactions = new ArrayList<>();
        for (Transaction transaction : transactions) {
            if (transaction.getAccountId().equals(accountId)) {
                accountTransactions.add(transaction);
            }
        }
        return accountTransactions;
    }
}