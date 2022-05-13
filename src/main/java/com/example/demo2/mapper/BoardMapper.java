package com.example.demo2.mapper;

import com.example.demo1.board.dto.BoardDto;
import com.example.demo1.board.dto.BoardFileDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<BoardDto> selectBoardList();
    void insertBoard(BoardDto board);
    void updateHitCount(int id);
    BoardDto selectBoardDetail(int id);
    void updateBoard(BoardDto board);
    void deleteBoard(int id);
    void insertBoardFileList(List<BoardFileDto> list);
    List<BoardFileDto> selectBoardFileList(int id);
}