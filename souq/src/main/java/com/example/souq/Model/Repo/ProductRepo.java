package com.example.souq.Model.Repo;

import com.example.souq.Model.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Integer> {
}
