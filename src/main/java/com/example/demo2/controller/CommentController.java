package com.example.demo2.controller;

import com.example.demo1.board.dto.CommentDto;
import com.example.demo1.board.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
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
    public int commentInsert(@RequestParam int bid, @RequestParam String comcontent){
        CommentDto comment = new CommentDto();
        comment.setBid(bid);
        comment.setComcontent(comcontent);
        comment.setComwriter("testuser");
        return commentService.insertCommentService(comment);
    }
    @PostMapping("/update")
    @ResponseBody
    private int commentUpdate(@RequestParam int id, @RequestParam String comcontent){
        CommentDto comment = new CommentDto();
        comment.setId(id);
        comment.setComcontent(comcontent);
        return commentService.updateCommentService(comment);
    }
    @GetMapping("/delete/{id}")
    @ResponseBody
    private int commentDelete(@PathVariable int id){
        return commentService.deleteCommentService(id);
    }
}