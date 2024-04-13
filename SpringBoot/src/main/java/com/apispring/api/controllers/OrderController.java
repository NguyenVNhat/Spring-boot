package com.apispring.api.controllers;

import com.apispring.api.dto.ResponeObject;
import com.apispring.api.models.Order;
import com.apispring.api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    OrderService orderService;
    @GetMapping("/getall")
    public ResponseEntity<ResponeObject> getall()
    {
        return orderService.getall();
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<ResponeObject> get(@PathVariable Integer id)
    {
        return orderService.get(id);
    }
    @GetMapping("/getbyuserid/{userid}")
    public ResponseEntity<ResponeObject> getbyuserid(@PathVariable Integer userid)
    {
        return orderService.getbyuserid(userid);
    }
    @GetMapping("/getbybookid/{bookid}")
    public ResponseEntity<ResponeObject> getbybookid(@PathVariable Integer bookid)
    {
        return orderService.getbybookid(bookid);
    }
    @GetMapping("/getbystatus/{status}")
    public ResponseEntity<ResponeObject> getbystatus(@PathVariable Integer status)
    {
        return orderService.getbystatus(status);
    }
    @PutMapping("/movestatus/{orderid}")
    public ResponseEntity<ResponeObject> movestatus(@PathVariable Integer orderid)
    {
        return orderService.moveStatus(orderid);
    }
    @PostMapping("/insert")
    public ResponseEntity<ResponeObject> insert(@RequestBody Order order)
    {
        return orderService.insert(order);
    }
    @PutMapping("/cancel/{orderid}")
    public ResponseEntity<ResponeObject> cancel(@PathVariable Integer orderid)
    {
        return orderService.cancel(orderid);
    }
}
