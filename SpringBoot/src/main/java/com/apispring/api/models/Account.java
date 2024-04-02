package com.apispring.api.models;

import javax.persistence.*;

@Entity
@Table(name = "account")
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

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
