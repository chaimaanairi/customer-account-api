/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.accountapi;

import com.example.accountapi.model.Account;
import com.example.accountapi.model.Customer;
import com.example.accountapi.service.AccountService;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author Hp
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountServiceTest {
    
    @Autowired
    private AccountService accountService;
    
    @Test
    public void testCreateAccount_WithInitialCredit() {
        // Step 1: Create a test customer
        Customer customer = new Customer("123", "John", "Doe");
        accountService.addCustomer(customer);
        
        // Step 2: Create a new account for the customer with initial credit
        Account account = accountService.createAccount("123", 1000);
        
        // Step 3: Assert that the account balance is correct
        assertEquals(1000, account.getBalance(), 0);
        
        // Step 4: Assert that a transaction was created
        assertEquals(1, account.getTransactions().size());
        assertEquals("DEPOSIT", account.getTransactions().get(0).getType());
    }
    
    @Test
    public void testCreateAccount_WithoutInitialCredit() {
        // Step 1: Create a test customer
        Customer customer = new Customer("456", "Jane", "Smith");
        accountService.addCustomer(customer);
        
        // Step 2: Create a new account for the customer without initial credit
        Account account = accountService.createAccount("456", 0);
        
        // Step 3: Assert that the account balance is 0
        assertEquals(0, account.getBalance(), 0);
        
        // Step 4: Assert that no transactions were created
        assertEquals(0, account.getTransactions().size());
    }
    
    @Test
    public void testGetCustomerInfo() {
        // Step 1: Create a test customer
        Customer customer = new Customer("789", "Michael", "Johnson");
        accountService.addCustomer(customer);
        
        // Step 2: Fetch customer info
        Customer fetchedCustomer = accountService.getCustomerInfo("789");
        
        // Step 3: Assert that the fetched customer's name is correct
        assertEquals("Michael", fetchedCustomer.getName());
        assertEquals("Johnson", fetchedCustomer.getSurname());
    }
    
    @Test(expected = RuntimeException.class)
    public void testCreateAccount_WithNonExistentCustomer() {
        // Try to create an account for a non-existent customer
        accountService.createAccount("nonexistent", 500);
    }
}

