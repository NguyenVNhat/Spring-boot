package com.apispring.api.repository;

import com.apispring.api.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface BookRepository  extends JpaRepository<Book,Integer> {
    Book findByid(Integer id);

}
