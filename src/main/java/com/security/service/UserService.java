package com.security.service;

import com.security.model.entity.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User getUser(String username);
    List<User> getAllUsers();
    void deleteUser(String username);
    User updateUser(User user);
}
