package com.example.souq.Controller;

import com.example.souq.Model.Entity.Order;
import com.example.souq.Service.OrderService;
import com.example.souq.exception.OrderNotFoundException;
import com.example.souq.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/getAll")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @PutMapping("update/{id}")
    public void updateOrder(@PathVariable int id, @RequestBody Order order) throws OrderNotFoundException {
        orderService.updateOrder(id, order);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addOrder(@RequestBody Order order) {
        return orderService.addOrder(order);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteOrderById(@RequestParam int id) {
        return orderService.deleteOrder(id);
    }

    @PutMapping("/{orderId}/product/{productId}")
    public void assignProductToOrder(
            @PathVariable int orderId,
            @PathVariable int productId
            ) throws OrderNotFoundException, UserNotFoundException {
        orderService.assignProcutToOrder(orderId, productId);
    }
}
