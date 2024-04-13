package com.apispring.api.controllers;

import com.apispring.api.dto.ResponeObject;
import com.apispring.api.models.Comment;
import com.apispring.api.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/comment")
public class CommentController {
    @Autowired
    CommentService commentService;
    @GetMapping("/getbybookid/{book_id}")
    public ResponseEntity<ResponeObject> getby_bookid(@PathVariable Integer book_id)
    {
        return commentService.getbybook_id(book_id);
    }
    @GetMapping("/getbyuserid/{user_id}")
    public ResponseEntity<ResponeObject> getby_userid(@PathVariable Integer user_id)
    {
        return commentService.getbyuser_id(user_id);
    }
    @PostMapping("/insert")
    public ResponseEntity<ResponeObject> insert(@RequestBody Comment comment){
        return commentService.insert(comment.getBookId(), comment.getUserid(), comment.getComment(),comment.getStatus());
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponeObject> delete(@PathVariable Integer id)
    {
        return commentService.delete(id);
    }
}
