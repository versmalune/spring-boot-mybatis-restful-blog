package com.example.demo2.controller;

import com.example.demo2.model.dto.CommentDto;
import com.example.demo2.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/list")
    @ResponseBody
    public List<CommentDto> commentList(@RequestParam Long id){
        return commentService.commentListService(id);
    }
    @PostMapping ("/insert")
    @ResponseBody
    public void commentInsert(@RequestParam Long bid, @RequestParam String comContent){
        CommentDto comment = new CommentDto();
        comment.setBid(bid);
        comment.setComContent(comContent);
        comment.setComWriter("TESTUSER");
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