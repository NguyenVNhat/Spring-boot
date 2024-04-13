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
    @GetMapping("/getall")
    public ResponseEntity<ResponeObject> getall()
    {
        return bookService.getall();
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<ResponeObject> getbook(@PathVariable Integer id)
    {
        return  bookService.get(id);
    }
    @GetMapping("/getbyname/{name}")
    public ResponseEntity<ResponeObject> getbyname(@PathVariable String name)
    {
        return bookService.getbyname(name);
    }
    @GetMapping("/getbyprice/{price}")
    public ResponseEntity<ResponeObject> getbyprice(@PathVariable Integer price)
    {
        return bookService.getbyprice(price);
    }
    @GetMapping("/getaroundprice/{lowprice}/{highprice}")
    public ResponseEntity<ResponeObject> getarroundprice(@PathVariable("lowprice") Integer lowprice,@PathVariable("highprice") Integer highprice)
    {
        return bookService.getaroundprice(lowprice,highprice);
    }
    @GetMapping("/getlowerprice/{price}")
    public ResponseEntity<ResponeObject> getlowerprice(@PathVariable Integer price)
    {
        return bookService.getlowerprice(price);
    }
    @GetMapping("/gethigherprice/{price}")
    public ResponseEntity<ResponeObject> gethigherprice(@PathVariable Integer price)
    {
        return bookService.gethigherprice(price);
    }
    @PostMapping("/insert")
    public ResponseEntity<ResponeObject> insert(@RequestBody Book book)
    {
        return bookService.insert(book);
    }
    @PutMapping("/update")
    public ResponseEntity<ResponeObject> update(@RequestBody Book book)
    {
        return bookService.update(book);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponeObject> delete(@PathVariable Integer id)
    {
        return bookService.delete(id);
    }

}
