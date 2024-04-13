package com.apispring.api.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "book")
@Data
public class Book {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "count")
    private Integer count;

    @Column(name = "image")
    private String image;

    @Column(name = "namebook")
    private String namebook;

    @Column(name = "price")
    private Integer price;

    @Column(name = "category_id")
    private Integer categoryId;

    public Book() {
    }

    public Book(Integer count, String image, String namebook, Integer price, Integer categoryId) {
        this.count = count;
        this.image = image;
        this.namebook = namebook;
        this.price = price;
        this.categoryId = categoryId;
    }


}
