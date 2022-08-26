package com.security.service.impl;

import com.security.model.entity.Customer;
import com.security.model.entity.SecurityCustomer;
import com.security.repo.CustomerRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerDetails implements UserDetailsService {

    private final CustomerRepo customerRepo;

    public CustomerDetails(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<Customer> customers = customerRepo.findByEmail(username);
        if(customers.size() == 0){
            throw new UsernameNotFoundException(username + " does not exist");
        }
        return new SecurityCustomer(customers.get(0));
    }

    public Customer createCustomer(Customer customer){
        customerRepo.save(customer);
        return customer;
    }


}
