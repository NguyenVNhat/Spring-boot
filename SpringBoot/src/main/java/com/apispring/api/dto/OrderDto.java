package com.apispring.api.dto;

import com.apispring.api.models.Book;
import com.apispring.api.models.User;
import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

@Data
public class OrderDto {
    private Integer id;
    private User user;
    private Book book;
    private Integer count;
    private String phone;
    private String address;
    private Integer voucherid;
    private Date dateorder;
    private Integer status;

    public OrderDto() {
    }

    public OrderDto(Integer id, User user, Book book, Integer count, String phone, String address, Integer voucherid, Date dateorder, Integer status) {
        this.id = id;
        this.user = user;
        this.book = book;
        this.count = count;
        this.phone = phone;
        this.address = address;
        this.voucherid = voucherid;
        this.dateorder = dateorder;
        this.status = status;
    }
}
