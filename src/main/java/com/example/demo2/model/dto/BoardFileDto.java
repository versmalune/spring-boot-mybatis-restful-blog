package com.example.demo2.model.dto;

import lombok.Data;

@Data
public class BoardFileDto {
    private int id;
    private int bid;
    private String originalFileName;
    private String storedFilePath;
    private long fileSize;
}
