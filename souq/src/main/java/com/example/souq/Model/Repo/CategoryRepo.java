package com.example.souq.Model.Repo;

import com.example.souq.Model.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
}
