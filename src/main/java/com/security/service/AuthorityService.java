package com.security.service;

import com.security.model.entity.Authority;

import java.util.List;

public interface AuthorityService {
    Authority createAuthority(Authority authority);
    List<Authority> getAllAuthority();
    Authority getAuthority(String username);
    void deleteAuthority(String username);
    Authority updateAuthority(Authority authority);
}
