package com.example.emailservice.core.Exceptions;

public class EmailServiceException extends RuntimeException{

    public EmailServiceException(String message, Throwable cause){
        super(message, cause);
    }
}
