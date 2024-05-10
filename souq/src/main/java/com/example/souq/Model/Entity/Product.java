package com.example.souq.Model.Entity;

import com.example.souq.Class.DTO.AddressDTO;
import com.example.souq.Class.DTO.CategoryDTO;
import com.example.souq.Class.DTO.ProductDTO;
import com.example.souq.Class.DTO.SupplierDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Column(columnDefinition = "decimal(10,2)")
    private double price;

    private String description;

    @ManyToOne
    private Category category;

    private int quantity;

    private String image;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    public static Product toProduct(ProductDTO dto) {
        return Product.builder()
                .id(dto.getId())
                .name(dto.getName())
                .image(dto.getImage())
                .category(Category.toCategory(dto.getCategory()))
                .supplier(Supplier.toSupplier(dto.getSupplier()))
                .quantity(dto.getQuantity())
                .description(dto.getDescription())
                .price(dto.getPrice())
                .build();
    }


    public static List<Product> toProductList(List<ProductDTO> products) {
        return products.stream()
                .map(product -> Product.builder()
                        .id(product.getId())
                        .name(product.getName())
                        .image(product.getImage())
                        .category(Category.toCategory(product.getCategory()))
                        .supplier(Supplier.toSupplier(product.getSupplier()))
                        .quantity(product.getQuantity())
                        .description(product.getDescription())
                        .price(product.getPrice())
                        .build())
                .collect(Collectors.toList());
    }
}
