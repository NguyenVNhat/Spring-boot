package com.apispring.api.dto;

import lombok.Data;

@Data
public class FileStorageDto {
    private String filename;
    private String filetype;
    private String filebase64;
}
