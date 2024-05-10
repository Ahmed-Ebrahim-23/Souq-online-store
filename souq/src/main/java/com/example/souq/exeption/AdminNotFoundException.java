package com.example.souq.exeption;

public class AdminNotFoundException extends ResourceNotFoundException {
    public AdminNotFoundException(String message) {
        super(message);
    }
}
