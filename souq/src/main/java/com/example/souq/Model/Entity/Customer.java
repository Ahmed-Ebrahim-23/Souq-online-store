package com.example.souq.Model.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table

public class Customer extends User{
    @OneToOne
    ShoppingCart cart;
}
