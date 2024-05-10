package com.example.souq.Class.DTO;

import com.example.souq.Class.Enum.EmployeeRole;
import com.example.souq.Model.Entity.Address;
import com.example.souq.Model.Entity.Admin;
import com.example.souq.Model.Entity.DeliveryManager;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
@Data
@NoArgsConstructor
//@AllArgsConstructor
//@Builder
public class AdminDTO extends EmployeeDTO{

    @Builder
    public AdminDTO(Integer id, Integer age, LocalDate birthdate, String name, String phone, AddressDTO address, String email, String password, EmployeeRole role) {
        super(id, age, birthdate, name, phone, email, password, address, role);
    }

    @Enumerated(EnumType.STRING)
    EmployeeRole role;
    public static List<AdminDTO> toAdminDTOList(List<Admin> admins) {
        return admins.stream()
                .map(admin -> AdminDTO.builder()
                        .id(admin.getId())
                        .age(admin.getAge())
                        .birthdate(admin.getBirthdate())
                        .name(admin.getName())
                        .phone(admin.getPhone())
                        .address(AddressDTO.toAddressDTO(admin.getAddress()))
                        .email(admin.getEmail())
//                        .password(admin.getPassword())
                        .role(admin.getRole())
                        .build())
                .collect(Collectors.toList());
    }


}
