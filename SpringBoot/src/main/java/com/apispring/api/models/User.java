package com.apispring.api.models;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "address")
    private String address;

    @Column(name = "avata")
    private String avata;

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;

    @Column(name = "account_id")
    private Integer accountId;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAvata() {
        return this.avata;
    }

    public void setAvata(String avata) {
        this.avata = avata;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getAccountId() {
        return this.accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }
}
