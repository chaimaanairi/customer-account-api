/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.accountapi.controllers;

import com.example.accountapi.model.Account;
import com.example.accountapi.model.Customer;
import com.example.accountapi.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Hp
 */

@RestController
public class AccountController {
    
    @Autowired
    private AccountService accountService;

    @PostMapping("/create")
    public ResponseEntity<Account> createAccount(@RequestParam String customerId, @RequestParam double initialCredit) {
        Account account = accountService.createAccount(customerId, initialCredit);
        return new ResponseEntity<>(account, HttpStatus.CREATED);
    }

    @GetMapping("/info/{customerId}")
    public ResponseEntity<Customer> getCustomerInfo(@PathVariable String customerId) {
        Customer customer = accountService.getCustomerInfo(customerId);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
}

