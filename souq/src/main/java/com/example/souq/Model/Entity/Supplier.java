package com.example.souq.Model.Entity;

import com.example.souq.Class.DTO.AddressDTO;
import com.example.souq.Class.DTO.AdminDTO;
import com.example.souq.Class.DTO.SupplierDTO;
import com.example.souq.Class.Enum.EmployeeRole;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import static com.example.souq.Model.Entity.Address.toAddress;

@Entity
@Table
@NoArgsConstructor
public class Supplier extends User{
    @Builder
    public Supplier(Integer id, Integer age, LocalDate birthdate, String name, String phone, Address address, String email, String password) {
        super(id, age, birthdate, name, phone, address, email, password);
    }

    public static Supplier toSupplier(SupplierDTO dto) {
        return Supplier.builder()
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
