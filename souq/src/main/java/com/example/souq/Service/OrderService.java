package com.example.souq.Service;

import com.example.souq.Class.DTO.OrderDTO;
import com.example.souq.Model.Entity.Customer;
import com.example.souq.Model.Entity.Order;
import com.example.souq.Model.Entity.Product;
import com.example.souq.Model.Repo.OrderRepo;
import com.example.souq.Model.Repo.ProductRepo;
import com.example.souq.exeption.OrderNotFoundException;
import com.example.souq.exeption.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepo orderRepo; // Changed from SupplierRepo to OrderRepo

    @Autowired
    private ProductRepo productRepo;

    public List<OrderDTO> getAllOrders() {
        List<Order> orders = orderRepo.findAll();
        return OrderDTO.toOrderDTOList(orders);
    }

    public void addOrder(OrderDTO order) {
        orderRepo.save(Order.toOrder(order));
    }

    // curCustomer.id update id (data)
    public void updateOrder(int id, OrderDTO updatedOrder) throws OrderNotFoundException {
        Order order = orderRepo.findById(id).orElseThrow(() -> new OrderNotFoundException("The order with id: " + id + " is not found"));

        order.setStatus(updatedOrder.getStatus());
        order.setCustomer(Customer.toCustomer(updatedOrder.getCustomer()));

        orderRepo.save(order);
    }

    public void deleteOrder(int id) throws OrderNotFoundException {
        Order order = orderRepo.findById(id).orElseThrow(() -> new OrderNotFoundException("The order with id: " + id + " is not found"));
        orderRepo.deleteById(id);
    }

    public void assignProductToOrder(int orderId, int productId) throws OrderNotFoundException, ProductNotFoundException {
        Order order = orderRepo.findById(orderId).orElseThrow(() -> new OrderNotFoundException("The order with id: " + orderId + " is not found"));
        Product product = productRepo.findById(productId).orElseThrow(() -> new ProductNotFoundException("The product with id: " + productId + " is not found"));

        List<Product> products = order.getItems();
        products.add(product);

        order.setItems(products);

        orderRepo.save(order);
    }
}
