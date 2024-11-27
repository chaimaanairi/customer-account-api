package com.example.accountapi.controller;

import com.example.accountapi.dto.AccountCreationRequest;
import com.example.accountapi.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
 
@RestController
@RequestMapping("/api/accounts")
public class AccountController {

   private final AccountService accountService;

   @Autowired
   public AccountController(AccountService accountService) {
       this.accountService = accountService;
   }

   @PostMapping("/open")
   public String openAccount(@RequestBody AccountCreationRequest request) {
       return accountService.openAccount(request.getCustomerId(), request.getInitialCredit());
   }
}
