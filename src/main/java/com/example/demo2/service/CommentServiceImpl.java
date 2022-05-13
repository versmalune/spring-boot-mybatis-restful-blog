package com.example.demo2.service;

import com.example.demo1.board.dto.CommentDto;
import com.example.demo1.board.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Override
    public List<CommentDto> commentListService(int bid) {
        return commentMapper.commentList(bid);
    }
    @Override
    public int insertCommentService(CommentDto comment){
        return commentMapper.commentInsert(comment);
    }
    @Override
    public int updateCommentService(CommentDto comment){
        return commentMapper.commentUpdate(comment);
    }
    @Override
    public int deleteCommentService(int id){
        return commentMapper.commentDelete(id);
    }
}