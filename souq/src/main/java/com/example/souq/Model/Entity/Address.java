package com.example.souq.Model.Entity;

import com.example.souq.Class.DTO.AddressDTO;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    Integer apartmentNumber;
    String street;
    String city;
    String country;

    public static Address toAddress(AddressDTO dto) {
        return Address.builder()
                .id(dto.getId())
                .apartmentNumber(dto.getApartmentNumber())
                .street(dto.getStreet())
                .city(dto.getCity())
                .country(dto.getCountry())
                .build();
    }
}
