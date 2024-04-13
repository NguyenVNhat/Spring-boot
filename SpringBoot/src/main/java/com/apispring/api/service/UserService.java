package com.apispring.api.service;

import com.apispring.api.dto.ResponeObject;
import com.apispring.api.dto.UserDto;
import com.apispring.api.models.Account;
import com.apispring.api.models.User;
import com.apispring.api.repository.AccountRepository;
import com.apispring.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    FileService fileService;
    @Autowired
    AccountRepository accountRepository;
    public ResponseEntity<ResponeObject> getall()
    {
        List<User> userList = userRepository.findAll();
        if (userList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponeObject("FALSE", "Fail to get list user", "")
            );
        }
        else {
            ArrayList<UserDto> userDtos = new ArrayList<>();
            for (User user : userList
            ) {
                Account account = accountRepository.findByid(user.getAccountId());
                UserDto userDto = new UserDto(account, user);
                userDtos.add(userDto);
            }
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponeObject("TRUE", "Success to get list user", userDtos)
            );
        }

    }
    public ResponseEntity<ResponeObject> get(Integer id)
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
    public  ResponseEntity<ResponeObject> getbyname(String name){
        List<User> userList = userRepository.findByname(name);
        if(userList.isEmpty())
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponeObject("FALSE", "Fail to get list user with name = "+name, "")
            );
        }
        else{
            ArrayList<UserDto> userDtos = new ArrayList<>();
            for (User user : userList
            ) {
                Account account = accountRepository.findByid(user.getAccountId());
                UserDto userDto = new UserDto(account, user);
                userDtos.add(userDto);
            }
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponeObject("TRUE", "Success to get list user with name = "+name, userDtos)
            );
        }
    }
    public  ResponseEntity<ResponeObject> getbyaddress(String address){
        List<User> userList = userRepository.findByaddress(address);
        if(userList.isEmpty())
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponeObject("FALSE", "Fail to get list user with address = "+address, "")
            );
        }
        else{
            ArrayList<UserDto> userDtos = new ArrayList<>();
            for (User user : userList
            ) {
                Account account = accountRepository.findByid(user.getAccountId());
                UserDto userDto = new UserDto(account, user);
                userDtos.add(userDto);
            }
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponeObject("TRUE", "Success to get list user with address = "+address, userDtos)
            );
        }
    }
    public ResponseEntity<ResponeObject> getbyphone(String phone){
        User user = userRepository.findByphone(phone);
        if(user == null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponeObject("FALSE", "Fail to get list user with phone = "+phone, "")
            );
        }
        else{
            Account account = accountRepository.findByid(user.getAccountId());
            UserDto userDto = new UserDto(account, user);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponeObject("TRUE", "Success to get list user with phone = "+phone, userDto)
            );
        }
    }
    public ResponseEntity<ResponeObject> update(User newuser)
    {
        User user = userRepository.findByid(newuser.getId());
        if (user == null) {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponeObject("FALSE", "Fail to insert new user", "")
            );
        }
        else{
            user.setAddress(newuser.getAddress());
            user.setAvata(newuser.getAvata());
            user.setName(newuser.getName());
            user.setPhone(newuser.getPhone());
            userRepository.save(user);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponeObject("TRUE","Success to insert new user",newuser)
            );
        }
    }

}
