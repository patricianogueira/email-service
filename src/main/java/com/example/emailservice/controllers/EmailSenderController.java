package com.example.emailservice.controllers;

import com.example.emailservice.application.EmailSenderService;
import com.example.emailservice.core.EmailRequest;
import com.example.emailservice.core.Exceptions.EmailServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/email")
public class EmailSenderController {
    private final EmailSenderService emailSender;

    @Autowired
    public EmailSenderController(EmailSenderService emailSenderService) {
        this.emailSender = emailSenderService;
    }

    @PostMapping
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest request) {
        try {
            this.emailSender.sendEmail(request.to(), request.subject(), request.body());
            return ResponseEntity.ok("email sent successfully");
        } catch (EmailServiceException exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while sending email");
        }
    }
}
