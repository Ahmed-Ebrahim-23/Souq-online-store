package com.example.souq.Model.Repo;

import com.example.souq.Model.Entity.ProductManager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductManagerRepo extends JpaRepository<ProductManager, Integer> {
}
