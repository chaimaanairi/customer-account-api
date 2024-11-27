package com.example.accountapi.repository;

import com.example.accountapi.model.Account;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class AccountRepository {
    private final Map<Long, Account> accounts = new HashMap<>();

    public void save(Account account) {
        accounts.put(account.getAccountId(), account);
    }

    public Account findById(Long accountId) {
        return accounts.get(accountId);
    }
}