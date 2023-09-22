package com.example.emailservice.core;

public interface EmailSenderUserCase {
    void sendEmail(String to, String subject, String body);
}
