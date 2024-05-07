package com.example.souq.Model.Repo;

import com.example.souq.Model.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order, Integer> {
}
