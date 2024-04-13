package com.apispring.api.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "`order`")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "userid")
    private Integer userid;
    @Column(name = "bookid")
    private Integer bookid;
    @Column(name = "count")
    private Integer count;
    @Column(name = "phone")
    private String phone;
    @Column(name = "address")
    private String address;
    @Column(name = "voucherid")
    private Integer voucherid;
    @Column(name = "dateorder")
    private Date dateorder;
    @Column(name = "status")
    private Integer status;
    public Order() {
    }
    public Order(Integer userid, Integer bookid, Integer count, String phone, String address, Integer voucherid, Date dateorder, Integer status) {
        this.userid = userid;
        this.bookid = bookid;
        this.count = count;
        this.phone = phone;
        this.address = address;
        this.voucherid = voucherid;
        this.dateorder = dateorder;
        this.status = status;
    }
}
