package com.example.souq.Model.Entity;

import com.example.souq.Class.DTO.AddressDTO;
import com.example.souq.Class.DTO.AdminDTO;
import com.example.souq.Class.DTO.CustomerDTO;
import com.example.souq.Class.Enum.EmployeeRole;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

import static com.example.souq.Model.Entity.Address.toAddress;

@Entity
@Table
@Data
@NoArgsConstructor
public class Customer extends User{
    @OneToOne
    ShoppingCart cart;

    @Builder
    public Customer(Integer id, Integer age, LocalDate birthdate, String name, String phone, Address address, String email, String password, ShoppingCart cart) {
        super(id, age, birthdate, name, phone, address, email, password);
        this.cart = cart;
    }

    public static Customer toCustomer(CustomerDTO dto) {
        return Customer.builder()
                .id(dto.getId())
                .age(dto.getAge())
                .birthdate(dto.getBirthdate())
                .name(dto.getName())
                .phone(dto.getPhone())
                .address(Address.toAddress(dto.getAddress()))
                .email(dto.getEmail())
                .password(dto.getPassword())
                .build();
    }
}
