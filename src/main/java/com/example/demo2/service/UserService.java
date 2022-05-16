package com.example.demo2.service;


import com.example.demo2.mapper.UserMapper;
import com.example.demo2.model.Account;
import com.example.demo2.model.AccountAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserMapper userMapper;
    @Transactional
    public void joinUser(Account account){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        account.setUserPw(passwordEncoder.encode(account.getPassword()));
        account.setUserAuth("USER");
        userMapper.saveUser(account);
    }
    @Override
    public AccountAdapter loadUserByUsername(String userName) throws UsernameNotFoundException {
        Account account = userMapper.getUserAccount(userName);
        System.out.println(account);
        System.out.println("here: " + userName);
        if (account == null) {
            throw new UsernameNotFoundException("User Not Authorized");
        }
        return new AccountAdapter(account);
    }
}