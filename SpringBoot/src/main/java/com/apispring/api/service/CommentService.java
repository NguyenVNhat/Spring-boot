package com.apispring.api.service;

import com.apispring.api.dto.CommentDto;
import com.apispring.api.dto.ResponeObject;
import com.apispring.api.models.Book;
import com.apispring.api.models.Comment;
import com.apispring.api.models.User;
import com.apispring.api.repository.BookRepository;
import com.apispring.api.repository.CommentRepository;
import com.apispring.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    BookRepository bookRepository;
    public ResponseEntity<ResponeObject> getbybook_id(Integer book_id)
    {
        List<Comment> comments = commentRepository.findBybookId(book_id);
        if (comments.isEmpty())
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponeObject("FALSE","Can't get list comment of book with id = "+book_id,"")
            );
        }
        else{
            ArrayList<CommentDto> commentDtos = new ArrayList<>();
            Book book = bookRepository.findByid(book_id);
            for (Comment comment: comments
                 ) {
                if(comment.getStatus())
                {
                    commentDtos.add(new CommentDto("người dùng ẩn danh",book.getNamebook(),comment.getComment()));
                }
                else{
                    User user = userRepository.findByid(comment.getUserid());
                    commentDtos.add(new CommentDto(user.getName(), book.getNamebook(),comment.getComment()));
                }
            }
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponeObject("TRUE","Success get list comment of book with id = "+book_id,commentDtos)
            );

        }
    }
    public ResponseEntity<ResponeObject> getbyuser_id(Integer user_id)
    {
        List<Comment> comments = commentRepository.findByuserid(user_id);
        if (comments.isEmpty())
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponeObject("FALSE","Can't get list comment of user with id = "+user_id,"")
            );
        }
        else{
            ArrayList<CommentDto> commentDtos = new ArrayList<>();
            User user = userRepository.findByid(user_id);
            for (Comment comment: comments
            ) {
                Book book = bookRepository.findByid(comment.getBookId());
                if(comment.getStatus())
                {
                    commentDtos.add(new CommentDto("Người dùng ẩn danh", book.getNamebook(), comment.getComment()));
                }
                else {
                    commentDtos.add(new CommentDto(user.getName(), book.getNamebook(), comment.getComment()));
                }
            }
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponeObject("TRUE","Success get list comment of user with id = "+user_id,commentDtos)
            );

        }
    }
    public String[] getwordDeny()
    {
        return new String[]{"cứt", "phê","ma túy"};
    }
    public ResponseEntity<ResponeObject> insert(Integer book_id,Integer user_id,String comment,Boolean status){
        String[] arrayList = getwordDeny();
        for (String item : arrayList) {
            comment = comment.replace(item, "**");
        }
        Comment comment1 = new Comment(comment,book_id,user_id,status);
        commentRepository.save(comment1);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponeObject("TRUE","Success insert new comment ",comment1)
        );

    }
    public ResponseEntity<ResponeObject> delete(Integer id)
    {
        Comment comment = commentRepository.findByid(id);
        if(comment != null)
        {
            commentRepository.delete(comment);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponeObject("TRUE","Success delete comment ",comment)
            );
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponeObject("False","Failed delete comment ","")
            );
        }
    }
}
