package com.example.demo2.model.dto;

import lombok.Data;

@Data
public class CommentDto {
    private Long id;
    private Long bid;
    private String comContent;
    private String comWriter;
}
