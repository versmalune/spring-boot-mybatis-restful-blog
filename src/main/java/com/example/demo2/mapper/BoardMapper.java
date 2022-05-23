package com.example.demo2.mapper;

import com.example.demo2.common.Criteria;
import com.example.demo2.model.dto.BoardDto;
import com.example.demo2.model.dto.BoardFileDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<BoardDto> selectBoardList(BoardDto board);
    int selectBoardTotalCount(BoardDto board);
    void insertBoard(BoardDto board);
    void updateHitCount(Long id);
    BoardDto selectBoardDetail(Long id);
    void updateBoard(BoardDto board);
    void deleteBoard(Long id);
    void insertBoardFileList(List<BoardFileDto> list);
    List<BoardFileDto> selectBoardFileList(Long id);
}