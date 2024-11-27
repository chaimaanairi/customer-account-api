package com.example.accountapi.dto;

import java.util.List;

public class UserInfoResponse {
    private String name;
    private String surname;
    private double balance;
    private List<TransactionInfo> transactions;

    // Constructors, Getters, and Setters
    public UserInfoResponse() {}

    public UserInfoResponse(String name, String surname, double balance, List<TransactionInfo> transactions) {
        this.name = name;
        this.surname = surname;
        this.balance = balance;
        this.transactions = transactions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<TransactionInfo> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<TransactionInfo> transactions) {
        this.transactions = transactions;
    }

    // Nested DTO for transaction info
    public static class TransactionInfo {
        private double amount;
        private String transactionDate;

        public TransactionInfo(double amount, String transactionDate) {
            this.amount = amount;
            this.transactionDate = transactionDate;
        }

        // Getters and Setters
        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public String getTransactionDate() {
            return transactionDate;
        }

        public void setTransactionDate(String transactionDate) {
            this.transactionDate = transactionDate;
        }
    }
}