package com.apispring.api.service;

import com.apispring.api.dto.ResponeObject;
import com.apispring.api.models.Book;
import com.apispring.api.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    FileService fileService;
    public ResponseEntity<ResponeObject> getAll()
    {
        List<Book> books = bookRepository.findAll();
        return books.isEmpty()?
            ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponeObject("False","Can't get all book",""))
        :   ResponseEntity.status(HttpStatus.OK).body(
                    new ResponeObject("True","Success to get all book",books));
    }
    public ResponseEntity<ResponeObject> get(Integer id)
    {
        Book books = bookRepository.findByid(id);
        System.out.println(books.getId());
        if( books == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponeObject("False", "Can't get book with id = " + id, ""));
        }
        else {
            return ResponseEntity.status(HttpStatus.OK).body(
                new ResponeObject("True", "Success to get book", books));
        }
    }
    public ResponseEntity<ResponeObject> insert(Book newbook)
    {
        System.out.println(newbook.getId());
        Book books = bookRepository.findByid(newbook.getId());
        if(books == null){
            newbook.setImage(fileService.convertToBase64(newbook.getImage()));
            System.out.println(newbook.getImage());
            bookRepository.save(newbook);
            return  ResponseEntity.status(HttpStatus.OK).body(
                    new ResponeObject("True","Success to insert new book",newbook));
        }
        else{
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponeObject("False","Failed to insert new book",""));
        }
    }
    public ResponseEntity<ResponeObject> update(Book newbook)
    {
        Book books = bookRepository.findByid(newbook.getId());
        if(books != null){
            books.setCategoryId(newbook.getCategoryId());
            books.setCount(newbook.getCount());
            books.setImage(newbook.getImage());
            books.setNamebook(newbook.getNamebook());
            books.setPrice(newbook.getPrice());
            bookRepository.save(books);
            return  ResponseEntity.status(HttpStatus.OK).body(
                    new ResponeObject("True","Success to insert new book",books));
        }
        else{
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponeObject("False","Failed to insert new book",""));
        }
    }
    public ResponseEntity<ResponeObject> delete(Integer id)
    {
        Book books = bookRepository.findByid(id);
        if(books != null){
           bookRepository.delete(books);
            return  ResponseEntity.status(HttpStatus.OK).body(
                    new ResponeObject("True","Success to delete book have id = "+id,""));
        }
        else{
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponeObject("False","Failed to delete book have id = "+id,""));
        }
    }
}
