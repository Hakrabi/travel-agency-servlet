package com.example.travel_agency.model.exception;

public class AppException extends RuntimeException{
    public AppException(String message, Throwable cause) {
        super(message, cause);
    }
}
