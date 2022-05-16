package com.example.demo2.model;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Getter
public class AccountAdapter extends User {
    private Account account;

    public AccountAdapter(Account account) {
        super(account.getUsername(), account.getPassword(), account.getAuthorities());
        this.account = account;
    }
}