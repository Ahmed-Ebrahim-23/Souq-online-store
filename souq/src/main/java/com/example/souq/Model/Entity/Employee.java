package com.example.souq.Model.Entity;

import com.example.souq.Class.Enum.EmployeeRole;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee extends User {
    @Enumerated(EnumType.STRING)
    private EmployeeRole role;

    public Employee(Integer id, Integer age, LocalDate birthdate, String name, String phone, Address address, String email, String password, EmployeeRole role) {
        super(id, age, birthdate, name, phone, address, email, password);
        this.role = role;
    }

}
