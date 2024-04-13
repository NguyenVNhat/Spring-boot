package com.apispring.api.controllers;

import com.apispring.api.dto.ResponeObject;
import com.apispring.api.models.Email;
import com.apispring.api.service.MailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/email")
public class EmailController {
    @Autowired
    MailSenderService mailSenderService;
    @PostMapping("/send")
    public ResponseEntity<ResponeObject> sendNewMail(@RequestBody Email email)
    {

       return mailSenderService.sendSimpleMessage(email);
    }
    @GetMapping("/read")
    public ResponseEntity<ResponeObject> readMail()
    {
        return mailSenderService.readMessage();
    }
}
