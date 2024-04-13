package com.apispring.api.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@Data
public class Roles {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "roles")
    private String roles;

    @Column(name = "account_id")
    private Integer accountId;

    public Roles() {
    }

    public Roles(String roles, Integer accountId) {
        this.roles = roles;
        this.accountId = accountId;
    }
}
