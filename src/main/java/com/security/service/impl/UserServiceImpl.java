package com.security.service.impl;

import com.security.model.entity.User;
import com.security.repo.UserRepo;
import com.security.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User createUser(User user) {
        log.info("User service is creating new user");
        return userRepo.save(user);
    }

    @Override
    public User getUser(String username) {
        User user = getUserByUsername(username);
        return user;
    }

    private User getUserByUsername(String username) {
        User user = userRepo.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException(username + " Username not found");
        }
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public void deleteUser(String username) {
        User user = getUserByUsername(username);
        userRepo.delete(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepo.save(user);
    }
}
