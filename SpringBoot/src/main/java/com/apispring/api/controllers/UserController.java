package com.apispring.api.controllers;

import com.apispring.api.dto.ResponeObject;
import com.apispring.api.models.User;
import com.apispring.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/getalluser")
    public ResponseEntity<ResponeObject> getalluser()
    {
        return userService.getalluser();
    }
    @PostMapping("/insertuser")
    public ResponseEntity<ResponeObject> insertuser(@RequestBody User user)
    {
        return  userService.insertuser(user);
    }


}

