package com.example.demo2.mapper;

import com.example.demo2.model.Account;
import com.example.demo2.model.dto.CommentDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository("com.example.demo2.mapper.CommentMapper")
public interface CommentMapper {
    List<CommentDto> commentList(Long bid);
    void commentInsert(CommentDto comment);
    void commentUpdate(CommentDto comment);
    void commentDelete(Long id);
}