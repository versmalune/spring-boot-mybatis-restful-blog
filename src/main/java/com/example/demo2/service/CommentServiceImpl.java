package com.example.demo2.service;

import com.example.demo2.mapper.CommentMapper;
import com.example.demo2.model.dto.CommentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Override
    public List<CommentDto> commentListService(Long bid) {
        return commentMapper.commentList(bid);
    }
    @Override
    public void insertCommentService(CommentDto comment){
        return commentMapper.commentInsert(comment);
    }
    @Override
    public void updateCommentService(CommentDto comment){
        return commentMapper.commentUpdate(comment);
    }
    @Override
    public void deleteCommentService(Long id){
        return commentMapper.commentDelete(id);
    }
}