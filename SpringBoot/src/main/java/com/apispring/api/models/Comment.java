package com.apispring.api.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "comment")
@Data
public class Comment {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "comment")
    private String comment;

    @Column(name = "book_id")
    private Integer bookId;

    @Column(name = "user_id")
    private Integer userid;
    @Column(name = "status")
    private Boolean status;
    public Comment() {
    }

    public Comment(String comment, Integer bookId, Integer userid, Boolean status) {
        this.comment = comment;
        this.bookId = bookId;
        this.userid = userid;
        this.status = status;
    }
}
