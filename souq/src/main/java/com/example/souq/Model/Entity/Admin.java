package com.example.souq.Model.Entity;

import com.example.souq.Class.DTO.AdminDTO;
import com.example.souq.Class.Enum.EmployeeRole;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.Builder;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.Date;

import static com.example.souq.Model.Entity.Address.toAddress;

@Entity
@Table
@NoArgsConstructor
public class Admin extends Employee {

    @Builder
    public Admin(Integer id, Integer age, LocalDate birthdate, String name, String phone, Address address, String email, String password, EmployeeRole role) {
        super(id, age, birthdate, name, phone, address, email, password, role);
    }

    public static Admin toAdmin(AdminDTO dto) {
        return Admin.builder()
                .id(dto.getId())
                .age(dto.getAge())
                .birthdate(dto.getBirthdate())
                .name(dto.getName())
                .phone(dto.getPhone())
                .address(toAddress(dto.getAddress()))
                .email(dto.getEmail())
                .password(dto.getPassword())
                .role(dto.getRole())
                .build();
    }
}
