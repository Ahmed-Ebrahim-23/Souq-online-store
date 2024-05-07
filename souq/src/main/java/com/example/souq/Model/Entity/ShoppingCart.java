package com.example.souq.Model.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Table

@Data

public class ShoppingCart {
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @ManyToMany
    @JoinTable(
            name = "Cart_Products",
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    List<Product> productList;
}
