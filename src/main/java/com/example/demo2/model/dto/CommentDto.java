package com.example.demo2.model.dto;

import lombok.Data;

@Data
public class CommentDto {
    private int id;
    private int bid;
    private String comcontent;
    private String comwriter;
}
