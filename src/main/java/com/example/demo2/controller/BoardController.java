package com.example.demo2.controller;

import com.example.demo2.common.CurrentUser;
import com.example.demo2.model.Account;
import com.example.demo2.model.AccountAdapter;
import com.example.demo2.model.dto.BoardDto;
import com.example.demo2.model.dto.CommentDto;
import com.example.demo2.service.BoardService;
import com.example.demo2.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/board")
public class BoardController {
    @Autowired
    private BoardService boardService;
    private AccountAdapter accountAdapter;

    @GetMapping("")
    public ModelAndView boardList(){
        ModelAndView mv = new ModelAndView("boardList");
        List<BoardDto> list = boardService.selectBoardList();
        mv.addObject("list", list);
        return mv;
    }
    @GetMapping("/new")
    public String boardWrite(){
        return "/boardWrite";
    }
    @GetMapping("/edit/{id}")
    public ModelAndView boardEdit(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView("boardEdit");
        BoardDto board = boardService.selectBoardDetail(id);
        mv.addObject("board", board);
        return mv;}
    @PostMapping("/")
    public String insertBoard(@ModelAttribute BoardDto board,
                              @CurrentUser Account account, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception{
        boardService.insertBoard(board, account, multipartHttpServletRequest);
        return "redirect:/board";
    }
    @GetMapping("/{id}")
    @ResponseBody
    public ModelAndView openBoardDetail(@PathVariable("id") Long id){
        ModelAndView mv = new ModelAndView("boardDetail");
        BoardDto board = boardService.selectBoardDetail(id);
        mv.addObject("board", board);
        return mv;
    }
    @PutMapping("/{id}")
    public String updateBoard(BoardDto board){
        log.info("=========in edit=======");
        boardService.updateBoard(board);
        return "redirect:/board";
    }
    @DeleteMapping("/{id}")
    public String deleteBoard(@PathVariable("id") Long id){
        log.info("==========in delete=========");
        boardService.deleteBoard(id);
        return "redirect:/board";
    }
}