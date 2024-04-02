package com.apispring.api.controllers;

import com.apispring.api.dto.ResponeObject;
import com.apispring.api.models.Book;
import com.apispring.api.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("api/book")
public class BookController {
    @Autowired
    BookService bookService;
    @GetMapping("/get/{id}")
    public ResponseEntity<ResponeObject> getbook(@PathVariable Integer id)
    {
        return  bookService.get(id);
    }
    @PostMapping("/insert")
    public ResponseEntity<ResponeObject> insert(@RequestBody Book book)
    {
        return bookService.insert(book);
    }
}
