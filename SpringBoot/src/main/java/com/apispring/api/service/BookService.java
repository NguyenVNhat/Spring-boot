package com.apispring.api.service;

import com.apispring.api.dto.BookDto;
import com.apispring.api.dto.ResponeObject;
import com.apispring.api.models.Book;
import com.apispring.api.models.Category;
import com.apispring.api.repository.BookRepository;
import com.apispring.api.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    FileService fileService;
    @Autowired
    CategoryRepository categoryRepository;
    public ResponseEntity<ResponeObject> getall()
    {
        List<Book> books = bookRepository.findAll();
        ArrayList<BookDto> bookDtos = new ArrayList<>();
        for ( Book book: books
             ) {
            Category category  = categoryRepository.findByid(book.getCategoryId());
            bookDtos.add(new BookDto(category,book));
        }
        return books.isEmpty()?
            ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponeObject("False","Can't get all book",""))
        :   ResponseEntity.status(HttpStatus.OK).body(
                    new ResponeObject("True","Success to get all book",bookDtos));
    }
    public ResponseEntity<ResponeObject> get(Integer id)
    {
        Book books = bookRepository.findByid(id);
        if( books == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponeObject("False", "Can't get book with id = " + id, ""));
        }
        else {
            return ResponseEntity.status(HttpStatus.OK).body(
                new ResponeObject("True", "Success to get book with id = "+id, books));
        }
    }
    public ResponseEntity<ResponeObject> getbyname(String name)
    {
        Book books = bookRepository.findBynamebook(name);
        if( books == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponeObject("False", "Can't get book with name = " + name, ""));
        }
        else {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponeObject("True", "Success to get book with name = "+name, books));
        }
    }
    public ResponseEntity<ResponeObject> getbyprice(Integer price){
        List<Book> books = bookRepository.findByprice(price);
        if( books.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponeObject("False", "Can't get book with price = " + price, ""));
        }
        else {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponeObject("True", "Success to get book with price = "+price, books));
        }
    }
    public ResponseEntity<ResponeObject> getaroundprice(Integer low,Integer high)
    {
        List<Book> books = bookRepository.findAll();
        if(books.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponeObject("False", "Can't get book" , ""));
        }
        else{
            ArrayList<Book> bookArrayList = new ArrayList<>();
            for (Book book:books
                 ) {
                if( book.getPrice() > low && book.getPrice() < high)
                {
                    bookArrayList.add(book);
                }
            }
            if(bookArrayList.isEmpty())
            {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponeObject("False", "Can't get book" , ""));
            }
            else{
                return ResponseEntity.status(HttpStatus.OK).body(
                        new ResponeObject("True", "Success to get book with price > "+low+" and < "+high, bookArrayList));
            }
        }
    }
    public  ResponseEntity<ResponeObject> getlowerprice(Integer price){
        List<Book> books = bookRepository.findAll();
        if(books.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponeObject("False", "Can't get book" , ""));
        }
        else{
            ArrayList<Book> bookArrayList = new ArrayList<>();
            for (Book book:books
            ) {
                if( book.getPrice() < price)
                {
                    bookArrayList.add(book);
                }
            }
            if(bookArrayList.isEmpty())
            {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponeObject("False", "Can't get book" , ""));
            }
            else{
                return ResponseEntity.status(HttpStatus.OK).body(
                        new ResponeObject("True", "Success to get book with price < "+price, bookArrayList));
            }
        }
    }
    public  ResponseEntity<ResponeObject> gethigherprice(Integer price){
        List<Book> books = bookRepository.findAll();
        if(books.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponeObject("False", "Can't get book" , ""));
        }
        else{
            ArrayList<Book> bookArrayList = new ArrayList<>();
            for (Book book:books
            ) {
                if( book.getPrice() > price)
                {
                    bookArrayList.add(book);
                }
            }
            if(bookArrayList.isEmpty())
            {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponeObject("False", "Can't get book" , ""));
            }
            else{
                return ResponseEntity.status(HttpStatus.OK).body(
                        new ResponeObject("True", "Success to get book with price < "+price, bookArrayList));
            }
        }
    }
    public ResponseEntity<ResponeObject> insert(Book newbook)
    {
        Book books = bookRepository.findByid(newbook.getId());
        if(books == null){
            newbook.setImage(fileService.convertToBase64(newbook.getImage()));
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
