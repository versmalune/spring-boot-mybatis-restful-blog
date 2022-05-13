package com.example.demo2.mapper;

import com.example.demo2.model.UserVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    void saveUser(UserVO userVO);
    UserVO getUserAccount(String userName);
}
