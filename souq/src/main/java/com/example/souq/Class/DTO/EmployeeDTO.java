package com.example.souq.Class.DTO;

import com.example.souq.Class.Enum.EmployeeRole;
import com.example.souq.Model.Entity.Address;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

//@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
//@Builder
public class EmployeeDTO extends UserDTO {
    @Enumerated(EnumType.STRING)
    EmployeeRole role;

    public EmployeeDTO(Integer id, Integer age, LocalDate birthdate, String name, String phone, String email, String password, AddressDTO address, EmployeeRole role) {
        super(id, age, birthdate, name, phone, email, password, address);
        this.role = role;
    }

}
