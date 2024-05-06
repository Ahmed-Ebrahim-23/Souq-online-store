package com.example.souq.Model.Entity;

import com.example.souq.Class.Enum.EmployeeRole;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Employee extends User{
    @Enumerated(EnumType.STRING)
    EmployeeRole role;
}
