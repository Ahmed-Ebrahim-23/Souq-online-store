package com.example.souq.Model.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@MappedSuperclass

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    Integer age;
    LocalDate birthdate;
    String name;
    String phone;
    @OneToOne
    Address address;
    String email;
    String password;
}
