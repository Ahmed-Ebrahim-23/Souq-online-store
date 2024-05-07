package com.example.souq.Model.Repo;

import com.example.souq.Model.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepo extends JpaRepository<Product, Integer> {
    Optional<Product> findById(int id);
}
