package com.example.souq.Class.DTO;

import com.example.souq.Class.Enum.EmployeeRole;
import com.example.souq.Model.Entity.Address;
import com.example.souq.Model.Entity.DeliveryManager;
import com.example.souq.Model.Entity.ProductManager;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class ProductManagerDTO extends EmployeeDTO {
    @Builder
    public ProductManagerDTO(Integer id, Integer age, LocalDate birthdate, String name, String phone, AddressDTO address, String email, String password, EmployeeRole role) {
        super(id, age, birthdate, name, phone, email, password, address, role);
    }
    public static List<ProductManagerDTO> toAdminDTOList(List<ProductManager> productManagers) {
        return productManagers.stream()
                .map(productManager -> ProductManagerDTO.builder()
                        .id(productManager.getId())
                        .age(productManager.getAge())
                        .birthdate(productManager.getBirthdate())
                        .name(productManager.getName())
                        .phone(productManager.getPhone())
                        .address(AddressDTO.toAddressDTO(productManager.getAddress()))
                        .email(productManager.getEmail())
//                        .password(deliveryManager.getPassword())
                        .role(productManager.getRole())
                        .build())
                .collect(Collectors.toList());
    }
}
