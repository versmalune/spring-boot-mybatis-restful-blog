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
    public List<CommentDto> commentList(@RequestParam int id){
        return commentService.commentListService(id);
    }
    @PostMapping ("/insert")
    @ResponseBody
    public void commentInsert(@RequestParam Long bid, @RequestParam String comcontent){
        CommentDto comment = new CommentDto();
        comment.setBid(bid);
        comment.setComContent(comcontent);
        comment.setComWriter("testuser");
        return commentService.insertCommentService(comment);
    }
    @PutMapping("/{id}")
    @ResponseBody
    private int commentUpdate(@RequestParam int id, @RequestParam String comcontent){
        CommentDto comment = new CommentDto();
        comment.setId(id);
        comment.setComcontent(comcontent);
        return commentService.updateCommentService(comment);
    }
    @DeleteMapping("/{id}")
    @ResponseBody
    private int commentDelete(@PathVariable int id){
        return commentService.deleteCommentService(id);
    }
}