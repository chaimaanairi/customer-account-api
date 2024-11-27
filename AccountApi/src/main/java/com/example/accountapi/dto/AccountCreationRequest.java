package com.example.accountapi.dto;

public class AccountCreationRequest {
    private Long customerId;
    private double initialCredit;

    // Constructors
    public AccountCreationRequest() {}

    public AccountCreationRequest(Long customerId, double initialCredit) {
        this.customerId = customerId;
        this.initialCredit = initialCredit;
    }

    // Getters and Setters
    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public double getInitialCredit() {
        return initialCredit;
    }

    public void setInitialCredit(double initialCredit) {
        this.initialCredit = initialCredit;
    }
}
