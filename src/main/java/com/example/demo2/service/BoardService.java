package com.example.demo2.service;

import com.example.demo1.board.dto.BoardDto;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;


public interface BoardService {
    List<BoardDto> selectBoardList();
    void insertBoard(BoardDto board, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception;
    BoardDto selectBoardDetail(int id);
    void updateBoard(BoardDto board);
    void deleteBoard(int id);
}
