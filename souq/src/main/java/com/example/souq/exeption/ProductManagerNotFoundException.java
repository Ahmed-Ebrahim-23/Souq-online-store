package com.example.souq.exeption;

public class ProductManagerNotFoundException extends ResourceNotFoundException {
    public ProductManagerNotFoundException(String message) {
        super(message);
    }
}
