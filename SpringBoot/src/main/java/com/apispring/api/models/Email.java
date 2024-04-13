package com.apispring.api.models;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class Email {
    String to;
    String subject;
    String body;

    public Email() {
    }

    public Email( String to, String subject, String body) {
        this.to = to;
        this.subject = subject;
        this.body = body;
    }
}
