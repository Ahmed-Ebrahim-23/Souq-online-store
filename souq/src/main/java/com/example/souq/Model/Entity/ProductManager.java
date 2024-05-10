package com.example.souq.Model.Entity;

import com.example.souq.Class.DTO.DeliveryManagerDTO;
import com.example.souq.Class.DTO.ProductManagerDTO;
import com.example.souq.Class.Enum.EmployeeRole;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table
@NoArgsConstructor
public class ProductManager extends Employee{
    @Builder
    public ProductManager(Integer id, Integer age, LocalDate birthdate, String name, String phone, Address address, String email, String password, EmployeeRole role) {
        super(id, age, birthdate, name, phone, address, email, password, role);
    }

    public static ProductManager toDeliveryManager(ProductManagerDTO dto) {
        return ProductManager.builder()
                .id(dto.getId())
                .age(dto.getAge())
                .birthdate(dto.getBirthdate())
                .name(dto.getName())
                .phone(dto.getPhone())
                .address(Address.toAddress(dto.getAddress()))
                .email(dto.getEmail())
                .password(dto.getPassword())
                .role(dto.getRole())
                .build();
    }
}
