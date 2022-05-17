package com.example.demo2.controller;

import com.example.demo2.common.CurrentUser;
import com.example.demo2.model.Account;
import com.example.demo2.model.dto.CommentDto;
import com.example.demo2.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/list")
    @ResponseBody
    public List<CommentDto> commentList(@RequestParam Long bid){
        return commentService.commentListService(bid);
    }
    @PostMapping ("/new")
    @ResponseBody
    public void commentInsert(@RequestParam Long bid, @CurrentUser Account account, @RequestParam String comContent){
        CommentDto comment = new CommentDto();
        comment.setBid(bid);
        comment.setComContent(comContent);
        comment.setComWriter(account.getUsername());
        commentService.insertCommentService(comment);
    }
    @PutMapping("/{id}")
    @ResponseBody
    public void commentUpdate(@RequestParam Long id, @RequestParam String comContent){
        CommentDto comment = new CommentDto();
        comment.setId(id);
        comment.setComContent(comContent);
        commentService.updateCommentService(comment);
    }
    @DeleteMapping("/{id}")
    @ResponseBody
    public void commentDelete(@PathVariable Long id){
        commentService.deleteCommentService(id);
    }
}