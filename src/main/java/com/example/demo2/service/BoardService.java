package com.example.demo2.service;

import com.example.demo2.common.Criteria;
import com.example.demo2.model.Account;
import com.example.demo2.model.dto.BoardDto;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;


public interface BoardService {
    List<BoardDto> selectBoardList(BoardDto board);
    void insertBoard(BoardDto board, Account account, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception;
    BoardDto selectBoardDetail(Long id);
    void updateBoard(BoardDto board);
    void deleteBoard(Long id);
}
