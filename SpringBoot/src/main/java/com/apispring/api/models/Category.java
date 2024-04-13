package com.apispring.api.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "category")
@Data
public class Category {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "category")
    private String category;

    public Category() {
    }

    public Category(Boolean active, String category) {
        this.active = active;
        this.category = category;
    }

}
