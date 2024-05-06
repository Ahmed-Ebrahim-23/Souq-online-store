package com.example.souq.Model.Entity;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Address {
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    Integer apartmentNumber;
    String street;
    String city;
    String country;
}
