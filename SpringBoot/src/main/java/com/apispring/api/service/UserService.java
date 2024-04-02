package com.apispring.api.service;

import com.apispring.api.dto.ResponeObject;
import com.apispring.api.models.User;
import com.apispring.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public ResponseEntity<ResponeObject> getalluser()
    {
        List<User> userList = userRepository.findAll();
        return userList.isEmpty()?
            ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponeObject("FALSE","Fail to get list user","")
            )
        :ResponseEntity.status(HttpStatus.OK).body(
                new ResponeObject("TRUE","Success to get list user",userList)
        );

    }
    public ResponseEntity<ResponeObject> getuser(Integer id)
    {
        User user = userRepository.findByid(id);
        return user == null ?
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponeObject("FALSE","Fail to get user","")
                )
                :ResponseEntity.status(HttpStatus.OK).body(
                new ResponeObject("TRUE","Success to get user",user)
        );
    }
    public ResponseEntity<ResponeObject> insertuser(User newuser)
    {
        User user = userRepository.findByid(newuser.getId());
        if (user != null) {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponeObject("FALSE", "Fail to insert new user", "")
            );
        }
        else{
            userRepository.save(newuser);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponeObject("TRUE","Success to insert new user",newuser)
            );
        }
    }

}
