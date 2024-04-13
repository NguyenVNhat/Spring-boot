package com.apispring.api.service;

import com.apispring.api.dto.ResponeObject;
import com.apispring.api.models.Account;
import com.apispring.api.models.User;
import com.apispring.api.repository.AccountRepository;
import com.apispring.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    UserRepository userRepository;
    PasswordEncoder passwordEncoder;
    public ResponseEntity<ResponeObject> getall()
    {
        List<Account> listAccount = (List<Account>) accountRepository.findAll();
        return listAccount.isEmpty()?
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponeObject("Not Found","System have not data","")
                ):
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponeObject("OK","List account :",listAccount)
                );
    }
    public Boolean IsValid(String username,String password)
    {
        Account account = accountRepository.findByusername(username);
        if (account!= null && account.getPassword().equals(password))
        {
            return true;
        }
        else{
            return false;
        }
    }
    public ResponseEntity<ResponeObject> get(Integer Id)
    {
        Optional<Account> accountFound = Optional.ofNullable(accountRepository.findByid(Id));
        return accountFound.isPresent()?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponeObject("OK","Querry account successfully",accountFound)
                ):
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponeObject("Not Found","Can't find account with id = "+Id,"")
                );
    }
    public ResponseEntity<ResponeObject> getByUsername(String username)
    {
        Optional<Account> accountFound = Optional.ofNullable(accountRepository.findByusername(username));
        return accountFound.isPresent()?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponeObject("TRUE","Querry account successfully",accountFound)
                ):
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponeObject("FALSE","Can't find account with username = "+username,"")
                );
    }
    public ResponseEntity<ResponeObject> getByRole(String role)
    {
        List<Account> account = accountRepository.findByrole(role);
        if (account == null){
            return   ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponeObject("FALSE","Can't find account with role = "+role,"")
            );
        }
        else{
            return   ResponseEntity.status(HttpStatus.OK).body(
                    new ResponeObject("TRUE","Success find account with role = "+role,account)
            );
        }
    }
    public ResponseEntity<ResponeObject> getByActive(Boolean active)
    {
        List<Account> account = accountRepository.findByactive(active);
        if (account == null){
            return   ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponeObject("FALSE","Can't find account with active = "+active,"")
            );
        }
        else{
            return   ResponseEntity.status(HttpStatus.OK).body(
                    new ResponeObject("TRUE","Success find account with active = "+active,account)
            );
        }
    }

    public  ResponseEntity<ResponeObject> update(Account newaccount)
    {
       Account account = accountRepository.findByid(newaccount.getId());
       if(account != null)
       {
           account.setUsername(newaccount.getUsername());
           account.setPassword(newaccount.getPassword());
           account.setRole(newaccount.getRole());
           account.setActive(newaccount.getActive());
           accountRepository.save(account);
           return ResponseEntity.status(HttpStatus.OK).body(
                   new ResponeObject("OK","Update successfully",newaccount)
           );
       }
       else return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
               new ResponeObject("Failed","Update failed","")
       );
    }
    public ResponseEntity<ResponeObject> deleteAccount(Integer Id)
    {
        Account account = accountRepository.findByid(Id);
        if(account != null)
        {
            accountRepository.deleteById(Id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponeObject("OK","Delete account with id = "+Id,"")
            );
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponeObject("Failed","Can't find account with id = "+Id,"")
            );
        }
    }
}
