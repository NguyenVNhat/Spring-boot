package com.apispring.api.models;

import javax.persistence.*;

@Entity
@Table(name = "book")
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

    public Book(Integer id, Integer count, String image, String namebook, Integer price, Integer categoryId) {
        this.id = id;
        this.count = count;
        this.image = image;
        this.namebook = namebook;
        this.price = price;
        this.categoryId = categoryId;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCount() {
        return this.count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getNamebook() {
        return this.namebook;
    }

    public void setNamebook(String namebook) {
        this.namebook = namebook;
    }

    public Integer getPrice() {
        return this.price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
}
