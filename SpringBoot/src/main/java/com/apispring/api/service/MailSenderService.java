package com.apispring.api.service;

import com.apispring.api.dto.ResponeObject;
import com.apispring.api.models.Email;
import jakarta.activation.DataHandler;
import jakarta.activation.FileDataSource;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.stereotype.Service;

import javax.mail.internet.AddressException;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Properties;

@Service
public class MailSenderService {

    @Autowired
    private JavaMailSender emailSender;

    public ResponseEntity<ResponeObject> sendSimpleMessage(Email email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email.getTo());
        message.setSubject(email.getSubject());
        message.setText(email.getBody());
        emailSender.send(message);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponeObject("TRUE", "Success to send email", email)
        );
    }

    public ResponseEntity<ResponeObject> readMessage() {
        String host = "imap.gmail.com";
        String username = "nhataaghjkl@gmail.com";
        String password = "wbueoqogakyaqhfd";

        Properties props = new Properties();
        props.setProperty("mail.store.protocol", "imaps");
        props.setProperty("mail.imap.ssl.enable", "true");

        ArrayList<String> messageReturn = new ArrayList<>();

        try {
            Session session = Session.getInstance(props, null);
            Store store = session.getStore();
            store.connect(host, username, password);
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);
            Message[] messages = inbox.getMessages();
            for (Message message : messages) {
                String subject = message.getSubject();
                String from = InternetAddress.toString(message.getFrom());
                String content = message.getContent().toString();
                messageReturn.add("Subject: " + subject + "\nFrom: " + from + "\nContent: " + content + "\n");
            }
            store.close();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    new ResponeObject("FALSE", "Failed to read emails", null)
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponeObject("TRUE", "Success to read emails", messageReturn)
        );
    }
}