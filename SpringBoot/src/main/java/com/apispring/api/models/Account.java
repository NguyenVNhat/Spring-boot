package com.apispring.api.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "account")
@Data
public class Account {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    @Column(name = "username")
    private String username;

    public Account() {
    }

    public Account(Boolean active, String password, String role, String username) {
        this.active = active;
        this.password = password;
        this.role = role;
        this.username = username;
    }


}
