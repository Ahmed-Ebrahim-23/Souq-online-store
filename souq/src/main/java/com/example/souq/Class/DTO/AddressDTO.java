package com.example.souq.Class.DTO;

import com.example.souq.Model.Entity.Address;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressDTO {
    Integer id;
    @NotNull(message = "apartment number shouldn't be null")
    Integer apartmentNumber;
    @NotNull(message = "street shouldn't be null")
    String street;
    @NotNull(message = "city shouldn't be null")
    String city;
    @NotNull(message = "country shouldn't be null")
    String country;

    // get
    public static AddressDTO toAddressDTO(Address address) {
        return AddressDTO.builder()
                .id(address.getId())
                .apartmentNumber(address.getApartmentNumber())
                .street(address.getStreet())
                .city(address.getCity())
                .country(address.getCountry())
                .build();
    }

    public static List<AddressDTO> toAddressDTOList(List<Address> addresses) {
        return addresses.stream()
                .map(address -> AddressDTO.builder()
                        .id(address.getId())
                        .apartmentNumber(address.getApartmentNumber())
                        .street(address.getStreet())
                        .city(address.getCity())
                        .country(address.getCountry())
                        .build())
                .collect(Collectors.toList());
    }



}
