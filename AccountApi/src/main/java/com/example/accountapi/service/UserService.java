package com.example.accountapi.service;

import com.example.accountapi.dto.UserInfoResponse;
import com.example.accountapi.exceptions.UserNotFoundException;
import com.example.accountapi.model.Account;
import com.example.accountapi.model.Transaction;
import com.example.accountapi.model.User;
import com.example.accountapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserInfoResponse getUserInfo(Long userId) {
        User user = userRepository.findById(userId);
        if (user == null) {
            throw new UserNotFoundException("User not found"); // Use the custom exception here
        }

        double totalBalance = 0;
        List<UserInfoResponse.TransactionInfo> transactionInfoList = new ArrayList<>();

        // Calculate total balance and compile list of transactions
        for (Account account : user.getAccounts()) {
            totalBalance += account.getBalance();
            for (Transaction transaction : account.getTransactions()) {
                UserInfoResponse.TransactionInfo transactionInfo = new UserInfoResponse.TransactionInfo(
                    transaction.getAmount(),
                    transaction.getTransactionDate().toString()
                );
                transactionInfoList.add(transactionInfo);
            }
        }

        return new UserInfoResponse(
                user.getName(),
                user.getSurname(),
                totalBalance,
                transactionInfoList
        );
    }
}