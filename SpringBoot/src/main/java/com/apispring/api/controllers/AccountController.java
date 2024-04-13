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
    @GetMapping("/getall")
    public ResponseEntity<ResponeObject> getall()
    {
        return accountService.getall();
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<ResponeObject> get(@PathVariable Integer id)
    {
        return accountService.get(id);
    }
    @GetMapping("/getbyusername/{username}")
    public ResponseEntity<ResponeObject> getbyusername(@PathVariable String username)
    {
        return accountService.getByUsername(username);
    }
    @GetMapping("/getbyrole/{role}")
    public ResponseEntity<ResponeObject> getbyrole(@PathVariable String role)
    {
        return accountService.getByRole(role);
    }
    @GetMapping("/getbyactive/{active}")
    public ResponseEntity<ResponeObject> getbyrole(@PathVariable Boolean active)
    {
        return accountService.getByActive(active);
    }
    @PutMapping("/update")
    public ResponseEntity<ResponeObject> updateAccount (@RequestBody Account account)
    {
        return  accountService.update(account);
    }

}
