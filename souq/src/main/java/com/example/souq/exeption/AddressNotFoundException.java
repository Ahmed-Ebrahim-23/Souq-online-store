package com.example.souq.exeption;

public class AddressNotFoundException extends ResourceNotFoundException {
    public AddressNotFoundException(String message) {
        super(message);
    }
}
