package com.example.souq.Model.Repo;

import com.example.souq.Model.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Integer>{
}
