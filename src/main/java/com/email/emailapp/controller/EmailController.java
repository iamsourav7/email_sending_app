package com.email.emailapp.controller;


import com.email.emailapp.payload.EmailRequest;
import com.email.emailapp.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    private final EmailService emailService;

    @Autowired
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/send-email")
    public void sendEmail(@RequestBody EmailRequest request) {
        emailService.sendEmail(request.getTo(), request.getSubject(), request.getBody());
    }
}

