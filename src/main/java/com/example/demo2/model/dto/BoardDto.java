package com.example.demo2.model.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class BoardDto {
    private Long id;
    private String title;
    private String content;
    private String writer;
    private Long viewCnt;
    private LocalDateTime createdDatetime;
    private List<BoardFileDto> fileList;
}
