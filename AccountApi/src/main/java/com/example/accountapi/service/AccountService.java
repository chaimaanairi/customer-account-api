package com.example.accountapi.service;

import com.example.accountapi.model.Account;
import com.example.accountapi.model.Transaction;
import com.example.accountapi.model.Customer;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class AccountService {
    private Map<String, Customer> customers = new HashMap<>();
    
    public Account createAccount(String customerId, double initialCredit) {
        Customer customer = customers.get(customerId);
        if (customer == null) {
            throw new RuntimeException("Customer not found");
        }

        Account account = new Account(UUID.randomUUID().toString(), 0);
        customer.getAccounts().add(account);
        
        // Add initial credit if provided
        if (initialCredit != 0) {
            Transaction transaction = new Transaction(UUID.randomUUID().toString(), initialCredit, "DEPOSIT", LocalDateTime.now());
            account.getTransactions().add(transaction);
            account.setBalance(initialCredit);
        }

        return account;
    }
    
    public Customer getCustomerInfo(String customerId) {
        Customer customer = customers.get(customerId);
        if (customer == null) {
            throw new RuntimeException("Customer not found");
        }
        return customer;
    }

    public void addCustomer(Customer customer) {
        customers.put(customer.getCustomerId(), customer);
    }
}
