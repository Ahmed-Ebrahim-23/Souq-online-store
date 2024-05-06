package com.example.souq.Model.Repo;

import com.example.souq.Model.Entity.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepo extends JpaRepository<ShoppingCart, Integer> {

}
