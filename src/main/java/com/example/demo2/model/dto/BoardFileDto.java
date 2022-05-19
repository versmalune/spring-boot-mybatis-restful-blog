package com.example.demo2.model.dto;

import lombok.Data;

@Data
public class BoardFileDto {
    private Long id;
    private Long bid;
    private String originalFileName;
    private String storedFilePath;
    private long fileSize;
    private String creatorId;
}
