package com.apispring.api.dto;

import lombok.Data;

import java.util.List;

@Data
public class CommentDto {
    private String username;
    private String bookname;
    private String comment;


    public CommentDto(String username, String bookname, String comment) {
        this.username = username;
        this.bookname = bookname;
        this.comment = comment;
    }
}
