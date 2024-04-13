package com.apispring.api.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Data
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

    public User() {
    }

    public User(String address, String avata, String name, String phone, Integer accountId) {
        this.address = address;
        this.avata = avata;
        this.name = name;
        this.phone = phone;
        this.accountId = accountId;
    }


}
