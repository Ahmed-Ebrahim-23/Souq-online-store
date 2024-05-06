package com.example.souq.Class.DTO;

import com.example.souq.Model.Entity.Address;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class UserResponse {
    Integer id;
    Integer age;
    LocalDate birthdate;
    String name;
    String phone;
    Address address;
    String email;
}
