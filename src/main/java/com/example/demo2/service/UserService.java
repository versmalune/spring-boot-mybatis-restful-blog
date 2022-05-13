package com.example.demo2.service;


import com.example.demo2.mapper.UserMapper;
import com.example.demo2.model.UserVO;
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
    public void joinUser(UserVO userVO){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        userVO.setUserPw(passwordEncoder.encode(userVO.getPassword()));
        userVO.setUserAuth("USER");
        userMapper.saveUser(userVO);
    }
    @Override
    public UserVO loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserVO userVO = userMapper.getUserAccount(userName);
        System.out.println(userVO);
        System.out.println("here" + userName);
        if (userVO == null) {
            throw new UsernameNotFoundException("User Not Authorized");
        }
        return userVO;
    }
}