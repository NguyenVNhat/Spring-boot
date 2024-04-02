package com.apispring.api.service;

import com.apispring.api.dto.ResponeObject;
import com.apispring.api.models.Account;
import com.apispring.api.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;
    public ResponseEntity<ResponeObject> getAllAccount()
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
        Account account = accountRepository.findByUsername(username);
        if (account!= null && account.getPassword().equals(password))
        {
            return true;
        }
        else{
            return false;
        }
    }
    public ResponseEntity<ResponeObject> getAccount(Integer Id)
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
    public ResponseEntity<ResponeObject> getAccountByUsername(String username)
    {
        Optional<Account> accountFound = Optional.ofNullable(accountRepository.findByUsername(username));
        return accountFound.isPresent()?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponeObject("OK","Querry account successfully",accountFound)
                ):
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponeObject("Not Found","Can't find account with username = "+username,"")
                );
    }
    public ResponseEntity<ResponeObject> createAccount(Account account)
    {
        Account accountFound = accountRepository.findByid(account.getId());
        if (accountFound == null)
               return ResponseEntity.status(HttpStatus.OK).body(
                new ResponeObject("OK","Insert successfully",accountRepository.save(account))
            );
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponeObject("Found","This data found in system",accountFound)
        );
    }
    public  ResponseEntity<ResponeObject> updateAccount(Account newaccount)
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
