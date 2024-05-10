package com.example.souq.exeption;

public class DeliveryManagerNotFoundException extends ResourceNotFoundException {
    public DeliveryManagerNotFoundException(String message) {
        super(message);
    }
}
