package com.example.souq.Class.DTO;

import com.example.souq.Model.Entity.Address;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    Integer id;
    @Min(18)
    @Max(60)
    Integer age;
    LocalDate birthdate;
    @NotNull(message = "username should not be null")
    String name;
    @NotNull(message = "phone should not be null")
    @Pattern(regexp = "[0-9]+", message = "invalid phone")
    String phone;
    @NotNull(message = "address should not be null")
    AddressDTO address;
    @NotNull(message = "email should not be null")
    @Email(message = "invalid email address")
    String email;
    // Minimum eight characters, at least one letter and one number:
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$")
    String password;
}
