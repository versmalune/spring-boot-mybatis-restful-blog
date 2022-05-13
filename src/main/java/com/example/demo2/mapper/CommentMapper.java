package com.example.demo2.mapper;

import com.example.demo1.board.dto.CommentDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository("com.example.demo1.board.mapper.CommentMapper")
public interface CommentMapper {
    List<CommentDto> commentList(int id);
    int commentInsert(CommentDto comment);
    int commentUpdate(CommentDto comment);
    int commentDelete(int id);
}