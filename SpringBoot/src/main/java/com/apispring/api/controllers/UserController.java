package com.apispring.api.controllers;

import com.apispring.api.dto.ResponeObject;
import com.apispring.api.models.User;
import com.apispring.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/getall")
    public ResponseEntity<ResponeObject> getall()
    {
        return userService.getall();
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<ResponeObject> get(@PathVariable Integer id)
    {
        return userService.get(id);
    }
    @GetMapping("/getbyname/{name}")
    public ResponseEntity<ResponeObject> getbyname(@PathVariable String name)
    {
        return userService.getbyname(name);
    }
    @GetMapping("/getbyaddress/{address}")
    public ResponseEntity<ResponeObject> getbyaddress(@PathVariable String address)
    {
        return userService.getbyaddress(address);
    }
    @GetMapping("/getbyphone/{phone}")
    public ResponseEntity<ResponeObject> getbyphone(@PathVariable String phone)
    {
        return userService.getbyphone(phone);
    }
    @PutMapping("/update")
    public ResponseEntity<ResponeObject> update(@RequestBody User user)
    {
        return  userService.update(user);
    }

}

