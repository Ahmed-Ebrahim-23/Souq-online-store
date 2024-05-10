package com.example.souq.Class.DTO;

import com.example.souq.Class.Enum.EmployeeRole;
import com.example.souq.Model.Entity.Address;
import com.example.souq.Model.Entity.Admin;
import com.example.souq.Model.Entity.DeliveryManager;
import lombok.*;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
//@AllArgsConstructor//(staticName = "build")
public class DeliveryManagerDTO extends EmployeeDTO {

    @Builder
    public DeliveryManagerDTO(Integer id, Integer age, LocalDate birthdate, String name, String phone, AddressDTO address, String email, String password, EmployeeRole role) {
        super(id, age, birthdate, name, phone, email, password, address, role);
    }
    public static List<DeliveryManagerDTO> toAdminDTOList(List<DeliveryManager> deliveryManagers) {
        return deliveryManagers.stream()
                .map(deliveryManager -> DeliveryManagerDTO.builder()
                        .id(deliveryManager.getId())
                        .age(deliveryManager.getAge())
                        .birthdate(deliveryManager.getBirthdate())
                        .name(deliveryManager.getName())
                        .phone(deliveryManager.getPhone())
                        .address(AddressDTO.toAddressDTO(deliveryManager.getAddress()))
                        .email(deliveryManager.getEmail())
//                        .password(deliveryManager.getPassword())
                        .role(deliveryManager.getRole())
                        .build())
                .collect(Collectors.toList());
    }
}
