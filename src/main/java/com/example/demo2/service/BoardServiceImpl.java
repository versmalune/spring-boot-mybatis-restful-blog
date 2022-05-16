package com.example.demo2.service;

import com.example.demo2.common.FileUtils;
import com.example.demo2.mapper.BoardMapper;
import com.example.demo2.model.dto.BoardDto;
import com.example.demo2.model.dto.BoardFileDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {
    @Autowired
    private BoardMapper boardMapper;
    @Autowired
    private FileUtils fileUtils;
    @Override
    public List<BoardDto> selectBoardList(){
        return boardMapper.selectBoardList();
    }
    @Override
    public void insertBoard(BoardDto board, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception{
        board.setContent(board.getContent().replaceAll("<p>", "").replaceAll("</p>", "")); //
        boardMapper.insertBoard(board);
        List<BoardFileDto> list = fileUtils.parseFileInfo(board.getId(), multipartHttpServletRequest);
        if (CollectionUtils.isEmpty(list) == false) {
            boardMapper.insertBoardFileList(list);
        }
    }
    @Override
    public BoardDto selectBoardDetail(Long id){
        System.out.println(id);
        BoardDto board = boardMapper.selectBoardDetail(id);
        List<BoardFileDto> fileList = boardMapper.selectBoardFileList(id);
        System.out.println(fileList);
        board.setFileList(fileList);
        System.out.println(board);
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
