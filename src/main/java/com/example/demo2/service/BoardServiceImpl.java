package com.example.demo2.service;

import com.example.demo2.common.Criteria;
import com.example.demo2.common.FileUtils;
import com.example.demo2.common.PaginationInfo;
import com.example.demo2.mapper.BoardMapper;
import com.example.demo2.model.Account;
import com.example.demo2.model.dto.BoardDto;
import com.example.demo2.model.dto.BoardFileDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.Collections;
import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {
    @Autowired
    private BoardMapper boardMapper;
    @Autowired
    private FileUtils fileUtils;
    @Override
    public List<BoardDto> selectBoardList(BoardDto board){
        List<BoardDto> boardList = Collections.emptyList();
        int boardTotalCount = boardMapper.selectBoardTotalCount(board);
        PaginationInfo paginationInfo = new PaginationInfo(board);
        paginationInfo.setTotalRecordCount(boardTotalCount);
        board.setPaginationInfo(paginationInfo);
        if (boardTotalCount > 0) {
            boardList = boardMapper.selectBoardList(board);
        }
        return boardList;
    }
    @Override
    public void insertBoard(BoardDto board, Account account, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception{
        board.setContent(board.getContent());
        board.setWriter(account.getUsername());
        boardMapper.insertBoard(board);
        List<BoardFileDto> list = fileUtils.parseFileInfo(account, board.getId(), multipartHttpServletRequest);
        if (CollectionUtils.isEmpty(list) == false) {
            boardMapper.insertBoardFileList(list);
        }
    }
    @Override
    public BoardDto selectBoardDetail(Long id){
        BoardDto board = boardMapper.selectBoardDetail(id);
        List<BoardFileDto> fileList = boardMapper.selectBoardFileList(id);
        board.setFileList(fileList);
        boardMapper.updateHitCount(id);
        return board;
    }
    @Override
    public void updateBoard(BoardDto board){
        boardMapper.updateBoard(board);
    }
    @Override
    public void deleteBoard(Long id){
        boardMapper.deleteBoard(id);
    }
}