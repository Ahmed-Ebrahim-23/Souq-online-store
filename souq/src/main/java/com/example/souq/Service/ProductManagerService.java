package com.example.souq.Service;

import com.example.souq.Model.Entity.ProductManager;
import com.example.souq.Model.Repo.ProductManagerRepo;
import com.example.souq.exception.ProductManagerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManagerService {
    @Autowired
    private ProductManagerRepo productManagerRepo; // Changed from SupplierRepo to ProductManagerRepo

    public List<ProductManager> getAllProductManagers() {
        List<ProductManager> productManagers = productManagerRepo.findAll();
        return productManagers;
    }

    public ResponseEntity<String> addProductManager(ProductManager productManager) {
        productManagerRepo.save(productManager);
        return new ResponseEntity<>("ProductManager added", HttpStatus.OK);
    }

    public void updateProductManager(int id, ProductManager updatedProductManager) throws ProductManagerNotFoundException {
        ProductManager productManager = productManagerRepo.findById(id).orElseThrow(() -> new ProductManagerNotFoundException());

        productManager.setAddress(updatedProductManager.getAddress());
        productManager.setAge(updatedProductManager.getAge());
        productManager.setName(updatedProductManager.getName());
        productManager.setEmail(updatedProductManager.getEmail());
        productManager.setBirthdate(updatedProductManager.getBirthdate());
        productManager.setPhone(updatedProductManager.getPhone());
        productManager.setPassword(updatedProductManager.getPassword());
        productManager.setRole(updatedProductManager.getRole());

        productManagerRepo.save(productManager);
    }

    public ResponseEntity<String> deleteProductManager(int id) {
        productManagerRepo.deleteById(id);
        return new ResponseEntity<>("ProductManager deleted", HttpStatus.OK);
    }
}
