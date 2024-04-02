package com.apispring.api.models;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Roles {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "roles")
    private String roles;

    @Column(name = "account_id")
    private Integer accountId;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoles() {
        return this.roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public Integer getAccountId() {
        return this.accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }
}
