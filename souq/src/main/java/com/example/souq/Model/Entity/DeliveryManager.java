package com.example.souq.Model.Entity;

import com.example.souq.Class.DTO.AddressDTO;
import com.example.souq.Class.DTO.AdminDTO;
import com.example.souq.Class.DTO.DeliveryManagerDTO;
import com.example.souq.Class.Enum.EmployeeRole;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Optional;

import static com.example.souq.Model.Entity.Address.toAddress;

@Entity
@Table
@NoArgsConstructor
public class DeliveryManager extends Employee{
    @Builder
    public DeliveryManager(Integer id, Integer age, LocalDate birthdate, String name, String phone, Address address, String email, String password, EmployeeRole role) {
        super(id, age, birthdate, name, phone, address, email, password, role);
    }

    public static DeliveryManager toDeliveryManager(DeliveryManagerDTO dto) {
        return DeliveryManager.builder()
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
