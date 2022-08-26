package com.security.service.impl;

import com.security.exception.AuthorityNotFoundException;
import com.security.model.entity.Authority;
import com.security.repo.AuthorityRepo;
import com.security.service.AuthorityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorityServiceImpl implements AuthorityService {

    private final AuthorityRepo authorityRepo;

    public AuthorityServiceImpl(AuthorityRepo authorityRepo) {
        this.authorityRepo = authorityRepo;
    }

    @Override
    public Authority createAuthority(Authority authority) {
        return authorityRepo.save(authority);
    }

    @Override
    public List<Authority> getAllAuthority() {
        return authorityRepo.findAll();
    }

    @Override
    public Authority getAuthority(String username) {
        Authority authority = getAuthorityFromUsername(username);
        return authority;
    }

    private Authority getAuthorityFromUsername(String username) {
        Authority authority = authorityRepo.findByUsername(username);
        if(authority == null){
            throw new AuthorityNotFoundException(username + " does not have any authority!");
        }
        return authority;
    }

    @Override
    public void deleteAuthority(String username) {
        Authority authority = getAuthorityFromUsername(username);
        authorityRepo.delete(authority);
    }

    @Override
    public Authority updateAuthority(Authority authority) {
        return authorityRepo.save(authority);
    }
}
