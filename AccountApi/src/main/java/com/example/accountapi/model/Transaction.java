package com.example.accountapi.model;
import java.time.LocalDateTime;

public class Transaction {
    private String transactionId;
    private double amount;
    private String type; // e.g., "DEPOSIT" or "WITHDRAWAL"
    private LocalDateTime date;

    public Transaction(String transactionId, double amount, String type, LocalDateTime date) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.type = type;
        this.date = date;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
    
    
}
