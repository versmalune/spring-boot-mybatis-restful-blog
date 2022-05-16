package com.example.demo2.mapper;

import com.example.demo2.model.Account;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    void saveUser(Account account);
    Account getUserAccount(String userName);
}