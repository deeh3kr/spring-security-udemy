package com.security.repo;

import com.security.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public interface CustomerRepo extends JpaRepository<Customer, Integer> {

    List<Customer> findByEmail(String email);

}
