package com.example.souq.Class.DTO;

import com.example.souq.Model.Entity.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class UserRequest {
    Integer id;
    Integer age;
    LocalDate birthdate;
    String name;
    String phone;
    Address address;
    String email;
    String password;
}
