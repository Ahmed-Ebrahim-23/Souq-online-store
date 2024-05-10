package com.example.souq.exeption;

public class SupplierNotFoundException extends ResourceNotFoundException{
    public SupplierNotFoundException(String message) {
        super(message);
    }
}
