package com.example.demo2.model;

import lombok.Getter;
import org.springframework.security.core.userdetails.User;


@Getter
public class AccountAdapter extends User {
    private Account account;

    public AccountAdapter(Account account) {
        super(account.getUsername(), account.getPassword(), account.getAuthorities());
        this.account = account;
    }
}