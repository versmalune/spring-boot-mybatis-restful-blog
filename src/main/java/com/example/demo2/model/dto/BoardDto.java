package com.example.demo2.model.dto;

import com.example.demo2.model.Common;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class BoardDto extends Common {
    private Long id;
    private String title;
    private String content;
    private String writer;
    private Long viewCnt;
    private LocalDateTime createdDatetime;
    private List<BoardFileDto> fileList;
}
