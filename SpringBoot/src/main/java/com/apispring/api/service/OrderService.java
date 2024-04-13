package com.apispring.api.service;

import com.apispring.api.dto.OrderDto;
import com.apispring.api.dto.ResponeObject;
import com.apispring.api.models.Book;
import com.apispring.api.models.Order;
import com.apispring.api.models.User;
import com.apispring.api.repository.BookRepository;
import com.apispring.api.repository.OrderRepository;
import com.apispring.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    BookRepository bookRepository;
    public ResponseEntity<ResponeObject> getall(){
        List<Order> orders = orderRepository.findAll();
        if( orders.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponeObject("FALSE", "Failed to get all order", "")
            );
        }
        else {
            List<OrderDto> orderDos = new ArrayList<>();
            for (Order order: orders
                 ) {
                User user = userRepository.findByid(order.getUserid());
                Book book = bookRepository.findByid(order.getBookid());
                orderDos.add(new OrderDto(order.getId(),user,book,order.getCount(),order.getPhone(),order.getAddress(),order.getVoucherid(),order.getDateorder(),order.getStatus()));
            }
            return  ResponseEntity.status(HttpStatus.OK).body(
                    new ResponeObject("TRUE", "Success to get all order", orderDos)
            );
        }
    }
    public ResponseEntity<ResponeObject> get(Integer id){
        Order orders = orderRepository.findByid(id);
        if( orders == null){
                return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponeObject("FALSE","Failed to get order with id = "+id,"")
                );
        }
        else {
            User user = userRepository.findByid(id);
            Book book = bookRepository.findByid(id);
            OrderDto orderDto = new OrderDto(orders.getId(),user,book,orders.getCount(),orders.getPhone(),orders.getAddress(),orders.getVoucherid(),orders.getDateorder(),orders.getStatus());
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponeObject("TRUE", "Success to get order with id = " + id, orderDto)
            );
        }

    }

    public ResponseEntity<ResponeObject> getbyuserid(Integer userid){
        List<Order> orders = orderRepository.findByuserid(userid);
        if( orders.isEmpty()) {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponeObject("FALSE", "Failed to get order with userid = " + userid, "")
            );
        }
        else {
            List<OrderDto> orderDos = new ArrayList<>();
            for (Order order: orders
            ) {
                User user = userRepository.findByid(order.getUserid());
                Book book = bookRepository.findByid(order.getBookid());
                orderDos.add(new OrderDto(order.getId(),user,book,order.getCount(),order.getPhone(),order.getAddress(),order.getVoucherid(),order.getDateorder(),order.getStatus()));
            }
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponeObject("TRUE", "Success to get order with userid = " + userid, orderDos)
            );
        }
    }
    public ResponseEntity<ResponeObject> getbybookid(Integer bookid){
        List<Order> orders = orderRepository.findBybookid(bookid);
        if( orders.isEmpty()) {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponeObject("FALSE", "Failed to get order with bookid = " + bookid, "")
            );
        }
        else {
            List<OrderDto> orderDos = new ArrayList<>();
            for (Order order: orders
            ) {
                User user = userRepository.findByid(order.getUserid());
                Book book = bookRepository.findByid(order.getBookid());
                orderDos.add(new OrderDto(order.getId(),user,book,order.getCount(),order.getPhone(),order.getAddress(),order.getVoucherid(),order.getDateorder(),order.getStatus()));
            }
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponeObject("TRUE", "Success to get order with bookid = " + bookid, orderDos)
            );
        }

    }
    public ResponseEntity<ResponeObject> getbydateorder(Date dateorder){
        List<Order> orders = orderRepository.findBydateorder(dateorder);
        if( orders.isEmpty()) {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponeObject("FALSE", "Failed to get order with dateorder = " + dateorder, "")
            );
        }
        else {
            List<OrderDto> orderDos = new ArrayList<>();
            for (Order order: orders
            ) {
                User user = userRepository.findByid(order.getUserid());
                Book book = bookRepository.findByid(order.getBookid());
                orderDos.add(new OrderDto(order.getId(),user,book,order.getCount(),order.getPhone(),order.getAddress(),order.getVoucherid(),order.getDateorder(),order.getStatus()));
            }
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponeObject("TRUE", "Success to get order with dateorder = " + dateorder, orderDos)
            );
        }

    }
    public ResponseEntity<ResponeObject> getbystatus(Integer status){
        List<Order> orders = orderRepository.findBystatus(status);
        if( orders.isEmpty()) {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponeObject("FALSE", "Failed to get order with status = " + status, "")
            );
        }
        else {
            List<OrderDto> orderDos = new ArrayList<>();
            for (Order order: orders
            ) {
                User user = userRepository.findByid(order.getUserid());
                Book book = bookRepository.findByid(order.getBookid());
                orderDos.add(new OrderDto(order.getId(),user,book,order.getCount(),order.getPhone(),order.getAddress(),order.getVoucherid(),order.getDateorder(),order.getStatus()));
            }
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponeObject("TRUE", "Success to get order with status = " + status, orderDos)
            );
        }
    }
    public  ResponseEntity<ResponeObject> moveStatus(Integer id){
        Order order1 = orderRepository.findByid(id);
        if(order1 == null)
        {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponeObject("FALSE","Failed to change order","")
            );
        }
        else{
            order1.setStatus(order1.getStatus() +1);
            orderRepository.save(order1);
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponeObject("TRUE","Success to change order",order1)
            );
        }

    }
    public ResponseEntity<ResponeObject> insert(Order neworder)
    {
        Order order1 = orderRepository.findByid(neworder.getId());
        if(order1 != null)
        {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponeObject("FALSE","Failed to insert order","")
            );
        }
        else{
            orderRepository.save(neworder);
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponeObject("TRUE","Success to insert order",neworder)
            );
        }
    }

    public ResponseEntity<ResponeObject> cancel(Integer id)
    {
        Order order1 = orderRepository.findByid(id);
        if(order1 == null || order1.getStatus() == 3)
        {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponeObject("FALSE","Failed to cancel order with id = "+id,"")
            );
        }
        else{
            order1.setStatus(4);
            orderRepository.save(order1);
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponeObject("TRUE","Success to cancel order with id = "+id,"")
            );
        }
    }
}
