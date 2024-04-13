package com.apispring.api.repository;

import com.apispring.api.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookRepository  extends JpaRepository<Book,Integer> {
    Book findByid(Integer id);
    Book findBynamebook(String name);
    List<Book> findBycategoryId(Integer category_id);
    List<Book> findByprice(Integer price);

}
