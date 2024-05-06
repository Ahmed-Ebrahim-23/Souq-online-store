package com.example.souq.Model.Entity;

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

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(columnDefinition = "decimal(10,2)")
    private double price;

    private String description;

    @ManyToOne
    private Category category;

    private Integer quantity;

    private String image;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;
}
