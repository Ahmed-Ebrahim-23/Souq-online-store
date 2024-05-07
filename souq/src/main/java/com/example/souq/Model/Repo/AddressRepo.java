package com.example.souq.Model.Repo;

import com.example.souq.Model.Entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address, Integer> {
}
