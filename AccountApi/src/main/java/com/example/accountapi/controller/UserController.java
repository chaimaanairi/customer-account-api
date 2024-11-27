package com.example.accountapi.controller;

import com.example.accountapi.dto.UserInfoResponse;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.accountapi.service.UserService;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Allow CORS for this method only
    @CrossOrigin(origins = "http://localhost:3000") // Frontend URL
    @GetMapping("/api/users/{customerId}")
    public UserInfoResponse getUserInfo(@PathVariable Long customerId) {
        return userService.getUserInfo(customerId); // Your method to fetch user info
    }
}
