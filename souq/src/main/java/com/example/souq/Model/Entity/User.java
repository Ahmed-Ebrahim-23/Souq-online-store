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
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer age;
    private LocalDate birthdate;
    private String name;
    private String phone;
    @OneToOne
    private Address address;
    private String email;
    private String password;
}
//{
//        "name": "supplier1",
//        "address": "address1",
//        "phone": "1234"
//        "birthdate": "2017-06-15"
//        "age": 11,
//        "email": "a@gmail.com"
//        "password": "1234"
//        "address": {
//
//        }
//        }