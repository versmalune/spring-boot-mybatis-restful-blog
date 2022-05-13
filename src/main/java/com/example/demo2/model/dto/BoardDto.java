package com.example.demo2.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class BoardDto {
    private int id;
    private String title;
    private String content;
    private String writer;
    private int viewcnt;
    private List<BoardFileDto> fileList;
}
