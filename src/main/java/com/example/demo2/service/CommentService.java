package com.example.demo2.service;


import com.example.demo2.model.Account;
import com.example.demo2.model.dto.CommentDto;

import java.util.List;

public interface CommentService {
    List<CommentDto> commentListService(Long bid);
    void insertCommentService(CommentDto comment);
    void updateCommentService(CommentDto comment);
    void deleteCommentService(Long id);
}
