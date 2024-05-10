package com.example.souq.Class.DTO;

import com.example.souq.Model.Entity.Address;
import com.example.souq.Model.Entity.Admin;
import com.example.souq.Model.Entity.Customer;
import com.example.souq.Model.Entity.ShoppingCart;
import jakarta.persistence.OneToOne;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.souq.Model.Entity.Address.toAddress;
@Data
public class CustomerDTO extends UserDTO {
    @OneToOne
    ShoppingCart cart;

    @Builder
    public CustomerDTO(Integer id, Integer age, LocalDate birthdate, String name, String phone, AddressDTO address, String email, String password, ShoppingCart cart) {
        super(id, age, birthdate, name, phone, email, password, address);
        this.cart = cart;
    }

    public static CustomerDTO toCustomerDTO(Customer customer) {
        return CustomerDTO.builder()
                .id(customer.getId())
                .age(customer.getAge())
                .birthdate(customer.getBirthdate())
                .name(customer.getName())
                .phone(customer.getPhone())
                .address(AddressDTO.toAddressDTO(customer.getAddress()))
                .email(customer.getEmail())
                .build();
    }

    public static List<CustomerDTO> toCustomerDTOList(List<Customer> customers) {
        return customers.stream()
                .map(customer -> CustomerDTO.builder()
                        .id(customer.getId())
                        .age(customer.getAge())
                        .birthdate(customer.getBirthdate())
                        .name(customer.getName())
                        .phone(customer.getPhone())
                        .address(AddressDTO.toAddressDTO(customer.getAddress()))
                        .email(customer.getEmail())
//                        .password(admin.getPassword())
                        .build())
                .collect(Collectors.toList());
    }
}
