package com.apispring.api.repository;

import com.apispring.api.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface CommentRepository extends JpaRepository<Comment,Integer> {
    Comment findByid(Integer id);
    List<Comment> findBybookId(Integer book_id);
    List<Comment> findByuserid(Integer user_id);
}
