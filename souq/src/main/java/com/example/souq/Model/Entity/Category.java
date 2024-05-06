package com.example.souq.Model.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table
@Entity

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Category {
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;
}
