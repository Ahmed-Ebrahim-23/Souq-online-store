package com.example.souq.Class.DTO;

import com.example.souq.Class.Enum.OrderStatus;
import com.example.souq.Model.Entity.Customer;
import com.example.souq.Model.Entity.Order;
import com.example.souq.Model.Entity.Product;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
public class OrderDTO {
    Integer id;
    @NotNull(message = "status shouldn't be null")
    OrderStatus status;
    List<ProductDTO> items;
    CustomerDTO customer;

    public static OrderDTO toOrderDTO(Order order) {
        return OrderDTO.builder()
                .id(order.getId())
                .status(order.getStatus())
                .customer(CustomerDTO.toCustomerDTO(order.getCustomer()))
                .items(ProductDTO.toProductDTOList(order.getItems()))
                .build();
    }

    public static List<OrderDTO> toOrderDTOList(List<Order> orders) {
        return orders.stream()
                .map(order -> OrderDTO.builder()
                        .id(order.getId())
                        .status(order.getStatus())
                        .customer(CustomerDTO.toCustomerDTO(order.getCustomer()))
                        .items(ProductDTO.toProductDTOList(order.getItems()))
                        .build())
                .collect(Collectors.toList());
    }

}
