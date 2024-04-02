package com.apispring.api.models;

import javax.persistence.*;

@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "comment")
    private String comment;

    @Column(name = "book_id")
    private Integer bookId;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getBookId() {
        return this.bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }
}
