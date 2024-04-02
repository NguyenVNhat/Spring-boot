package com.apispring.api.models;

import javax.persistence.*;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "active")
    private String active;

    @Column(name = "category")
    private String category;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getActive() {
        return this.active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
