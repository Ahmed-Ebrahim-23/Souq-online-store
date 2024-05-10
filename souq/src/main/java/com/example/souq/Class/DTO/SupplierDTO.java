package com.example.souq.Class.DTO;

import com.example.souq.Class.Enum.EmployeeRole;
import com.example.souq.Model.Entity.Address;
import com.example.souq.Model.Entity.Admin;
import com.example.souq.Model.Entity.DeliveryManager;
import com.example.souq.Model.Entity.Supplier;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class SupplierDTO extends UserDTO {

    @Builder
    public SupplierDTO(Integer id, Integer age, LocalDate birthdate, String name, String phone, AddressDTO address, String email, String password) {
        super(id, age, birthdate, name, phone, email, password, address);
    }

    public static SupplierDTO toSupplierDTO(Supplier supplier) {
        return SupplierDTO.builder()
                .id(supplier.getId())
                .age(supplier.getAge())
                .birthdate(supplier.getBirthdate())
                .name(supplier.getName())
                .phone(supplier.getPhone())
                .address(AddressDTO.toAddressDTO(supplier.getAddress()))
                .email(supplier.getEmail())
                .build();
    }
    public static List<SupplierDTO> toAdminDTOList(List<Supplier> suppliers) {
        return suppliers.stream()
                .map(supplier -> SupplierDTO.builder()
                        .id(supplier.getId())
                        .age(supplier.getAge())
                        .birthdate(supplier.getBirthdate())
                        .name(supplier.getName())
                        .phone(supplier.getPhone())
                        .address(AddressDTO.toAddressDTO(supplier.getAddress()))
                        .email(supplier.getEmail())
//                        .password(deliveryManager.getPassword())
                        .build())
                .collect(Collectors.toList());
    }
}
