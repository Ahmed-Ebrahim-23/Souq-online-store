package com.example.souq.Service;

import com.example.souq.Model.Entity.Order;
import com.example.souq.Model.Entity.Product;
import com.example.souq.Model.Repo.OrderRepo;
import com.example.souq.Model.Repo.ProductRepo;
import com.example.souq.exception.OrderNotFoundException;
import com.example.souq.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepo orderRepo; // Changed from SupplierRepo to OrderRepo

    @Autowired
    private ProductRepo productRepo;

    public List<Order> getAllOrders() {
        List<Order> orders = orderRepo.findAll();
        return orders;
    }

    public ResponseEntity<String> addOrder(Order order) {
        orderRepo.save(order);
        return new ResponseEntity<>("Order added", HttpStatus.OK);
    }

    public void updateOrder(int id, Order updatedOrder) throws OrderNotFoundException {
        Order order = orderRepo.findById(id).orElseThrow(() -> new OrderNotFoundException());

        order.setStatus(updatedOrder.getStatus());
        order.setCustomer(updatedOrder.getCustomer());

        orderRepo.save(order);
    }

    public ResponseEntity<String> deleteOrder(int id) {
        orderRepo.deleteById(id);
        return new ResponseEntity<>("Order deleted", HttpStatus.OK);
    }

    public void assignProcutToOrder(int orderId, int productId) throws OrderNotFoundException, UserNotFoundException {
        Order order = orderRepo.findById(orderId).orElseThrow(() -> new OrderNotFoundException());
        Product product = productRepo.findById(productId).orElseThrow(() -> new UserNotFoundException());

        List<Product> products = order.getItems();
        products.add(product);

        order.setItems(products);

        orderRepo.save(order);
    }
}
