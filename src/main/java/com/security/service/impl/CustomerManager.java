//package com.security.service.impl;
//
//import com.security.model.entity.Customer;
//import com.security.model.entity.SecurityCustomer;
//import com.security.repo.CustomerRepo;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.provisioning.UserDetailsManager;
//
//public class CustomerManager implements UserDetailsManager {
//
//    private final CustomerRepo customerRepo;
//
//    public CustomerManager(CustomerRepo customerRepo) {
//        this.customerRepo = customerRepo;
//    }
//
//    @Override
//    public void createUser(UserDetails user) {
//
//        SecurityCustomer customer = (SecurityCustomer) user;
//        customerRepo.save(SecurityCustomer(new Customer()));
//    }
//
//    @Override
//    public void updateUser(UserDetails user) {
//
//    }
//
//    @Override
//    public void deleteUser(String username) {
//
//    }
//
//    @Override
//    public void changePassword(String oldPassword, String newPassword) {
//
//    }
//
//    @Override
//    public boolean userExists(String username) {
//        return false;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return null;
//    }
//}
