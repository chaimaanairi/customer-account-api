package com.example.accountapi.repository;

import com.example.accountapi.model.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository {
    private final Map<Long, User> users = new HashMap<>();  // Simulate a database with a HashMap

    public User findById(Long userId) {
        return users.get(userId);
    }

    public void save(User user) {
        users.put(user.getId(), user);
    }
}
