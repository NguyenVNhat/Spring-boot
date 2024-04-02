package com.apispring.api.controllers;


import com.apispring.api.dto.ResponeObject;
import com.apispring.api.models.Account;
import com.apispring.api.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/account")
public class AccountController {
    @Autowired
    AccountService accountService;
    @GetMapping("/getAll")
    public ResponseEntity<ResponeObject> getAllAccount()
    {
        return accountService.getAllAccount();
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<ResponeObject> getAccount(@PathVariable("id") Integer Id)
    {
       return  accountService.getAccount(Id);
    }

    @PostMapping("/add")
    public ResponseEntity<ResponeObject> registerAccount (@RequestBody Account account)
    {
       return  accountService.createAccount(account);
    }
    @PutMapping("/update")
    public ResponseEntity<ResponeObject> updateAccount (@RequestBody Account account)
    {
        return  accountService.updateAccount(account);
    }
}
