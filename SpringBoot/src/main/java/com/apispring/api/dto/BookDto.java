package com.apispring.api.dto;

import com.apispring.api.models.Book;
import com.apispring.api.models.Category;
import lombok.Data;

@Data
public class BookDto {
    private Category category;
    private Book book;

    public BookDto(Category category, Book book) {
        this.category = category;
        this.book = book;
    }
}
