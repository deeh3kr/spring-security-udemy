package com.security.controller;

import com.security.model.entity.Authority;
import com.security.model.entity.Customer;
import com.security.model.entity.User;
import com.security.service.AuthorityService;
import com.security.service.UserService;
import com.security.service.impl.CustomerDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@Slf4j
public class UserController {

    private final UserService userService;
    private final AuthorityService authorityService;
    private final CustomerDetails customerDetails;

    public UserController(UserService userService, AuthorityService authorityService, CustomerDetails customerDetails) {
        this.userService = userService;
        this.authorityService = authorityService;
        this.customerDetails = customerDetails;
    }

    @PostMapping("/user")
    ResponseEntity<?> createUser(@RequestBody User user){
        log.info("Creating user...");
        User user1 = userService.createUser(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping("/users")
    ResponseEntity<?> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/user/{username}")
    ResponseEntity<?> getUser(@PathVariable String username){
        return new ResponseEntity<>(userService.getUser(username), HttpStatus.OK);
    }

    @PostMapping("/authority")
    ResponseEntity<?> createAuthority(@RequestBody Authority authority){
        return new ResponseEntity<>(authorityService.createAuthority(authority), HttpStatus.CREATED);
    }

    @GetMapping("/authorities")
    ResponseEntity<?> getAllAuthority(){
        return new ResponseEntity<>(authorityService.getAllAuthority(), HttpStatus.OK);
    }

    @GetMapping("/authority/{username}")
    ResponseEntity<?> getAuthorityByUsername(@PathVariable String username){
        return new ResponseEntity<>(authorityService.getAuthority(username), HttpStatus.OK);
    }

    @PostMapping("/customer")
    ResponseEntity<?> createCustomer(@RequestBody Customer customer){
        return new ResponseEntity<>(customerDetails.createCustomer(customer), HttpStatus.CREATED);
    }
}
