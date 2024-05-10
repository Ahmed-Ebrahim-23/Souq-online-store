package com.example.souq.Model.Entity;

import com.example.souq.Class.DTO.OrderDTO;
import com.example.souq.Class.Enum.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "orders")
@Entity

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @Enumerated(EnumType.STRING)
    OrderStatus status;
    @ManyToMany
    @JoinTable(
            name = "Order_Products",
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    List<Product> items;
    @ManyToOne
    Customer customer;

    public static Order toOrder(OrderDTO dto) {
        return Order.builder()
                .id(dto.getId())
                .status(dto.getStatus())
                .customer(Customer.toCustomer(dto.getCustomer()))
                .items(Product.toProductList(dto.getItems()))
                .build();
    }
}
