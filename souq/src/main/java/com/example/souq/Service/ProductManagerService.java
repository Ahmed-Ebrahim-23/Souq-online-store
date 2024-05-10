package com.example.souq.Service;

import com.example.souq.Class.DTO.ProductDTO;
import com.example.souq.Class.DTO.ProductManagerDTO;
import com.example.souq.Model.Entity.Address;
import com.example.souq.Model.Entity.ProductManager;
import com.example.souq.Model.Repo.ProductManagerRepo;
import com.example.souq.exeption.ProductManagerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManagerService {
    @Autowired
    private ProductManagerRepo productManagerRepo; // Changed from SupplierRepo to ProductManagerRepo

    public List<ProductManagerDTO> getAllProductManagers() {
        List<ProductManager> productManagers = productManagerRepo.findAll();
        return ProductManagerDTO.toAdminDTOList(productManagers);
    }

    public void addProductManager(ProductManagerDTO productManager) {
        productManagerRepo.save(ProductManager.toDeliveryManager(productManager));
    }

    public void updateProductManager(int id, ProductManagerDTO updatedProductManager) throws ProductManagerNotFoundException {
        ProductManager productManager = productManagerRepo.findById(id).orElseThrow(() -> new ProductManagerNotFoundException("The product manager with id: " + id + " is not found"));

        productManager.setAddress(Address.toAddress(updatedProductManager.getAddress()));
        productManager.setAge(updatedProductManager.getAge());
        productManager.setName(updatedProductManager.getName());
        productManager.setEmail(updatedProductManager.getEmail());
        productManager.setBirthdate(updatedProductManager.getBirthdate());
        productManager.setPhone(updatedProductManager.getPhone());
        productManager.setPassword(updatedProductManager.getPassword());
        productManager.setRole(updatedProductManager.getRole());

        productManagerRepo.save(productManager);
    }

    public void deleteProductManager(int id) throws ProductManagerNotFoundException {
        ProductManager productManager = productManagerRepo.findById(id).orElseThrow(() -> new ProductManagerNotFoundException("The product manager with id: " + id + " is not found"));
        productManagerRepo.deleteById(id);
    }
}
