package com.example.souq.Class.DTO;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Integer id;
    @Min(18)
    private Integer age;
    private LocalDate birthdate;
    @NotNull(message = "user name shouldn't be null")
    private String name;
    @Pattern(regexp = "[0-9]+", message = "invalid phone number")
    @NotNull
    private String phone;
    @Email(message = "invalid email address")
    @NotNull(message = "email shouldn't be null")
    private String email;
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$")
    private String password;
    @NotNull(message = "address shouldn't be null")
    private AddressDTO address;
}
