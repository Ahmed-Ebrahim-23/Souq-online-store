package com.example.souq.Controller;

import com.example.souq.Class.DTO.OrderDTO;
import com.example.souq.Service.OrderService;
import com.example.souq.exeption.OrderNotFoundException;
import com.example.souq.exeption.ProductNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/getAll")
    public List<OrderDTO> getAllOrders() {
        return orderService.getAllOrders();
    }

    @PutMapping("update/{id}")
    public void updateOrder(@PathVariable int id, @RequestBody @Valid OrderDTO order) throws OrderNotFoundException {
        orderService.updateOrder(id, order);
    }

    @PostMapping("/add")
    public void addOrder(@RequestBody @Valid OrderDTO order) {
        orderService.addOrder(order);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOrderById(@RequestParam int id) throws OrderNotFoundException {
        orderService.deleteOrder(id);
    }

    @PutMapping("/{orderId}/product/{productId}")
    public void assignProductToOrder(
            @PathVariable int orderId,
            @PathVariable int productId
            ) throws OrderNotFoundException, ProductNotFoundException {
        orderService.assignProductToOrder(orderId, productId);
    }
}

