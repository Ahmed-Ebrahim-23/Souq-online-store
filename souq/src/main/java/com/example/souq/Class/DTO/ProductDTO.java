package com.example.souq.Class.DTO;

import com.example.souq.Model.Entity.Address;
import com.example.souq.Model.Entity.Category;
import com.example.souq.Model.Entity.Product;
import com.example.souq.Model.Entity.Supplier;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.*;
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
public class ProductDTO {
    private int id;
    @NotNull(message = "name shouldn't be null")
    private String name;

    @NotNull(message = "price shouldn't be null")
    @Min(1)
    private double price;

    @NotNull(message = "description shouldn't be null")
    private String description;

    private CategoryDTO category;

    @NotNull(message = "quantity shouldn't be null")
    private int quantity;

    @NotNull(message = "image shouldn't be null")
    private String image;

    private SupplierDTO supplier;

    public static ProductDTO toProductDTO(Product product) {
        return ProductDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .image(product.getImage())
                .category(CategoryDTO.toCategoryDTO(product.getCategory()))
                .supplier(SupplierDTO.toSupplierDTO(product.getSupplier()))
                .quantity(product.getQuantity())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }

    public static List<ProductDTO> toProductDTOList(List<Product> products) {
        return products.stream()
                .map(product -> ProductDTO.builder()
                        .id(product.getId())
                        .name(product.getName())
                        .image(product.getImage())
                        .category(CategoryDTO.toCategoryDTO(product.getCategory()))
                        .supplier(SupplierDTO.toSupplierDTO(product.getSupplier()))
                        .quantity(product.getQuantity())
                        .description(product.getDescription())
                        .price(product.getPrice())
                        .build())
                .collect(Collectors.toList());
    }
}
