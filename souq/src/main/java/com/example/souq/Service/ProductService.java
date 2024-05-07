package com.example.souq.Service;

import com.example.souq.Model.Entity.Product;
import com.example.souq.Model.Repo.ProductRepo;
import com.example.souq.exeption.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
//import java.util.Optional;


import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;


    public List<Product> getAllProducts() {
        List<Product> products = productRepo.findAll();
        return products;
    }


    public ResponseEntity<String> addProduct(Product product) {
        productRepo.save(product);
        return new ResponseEntity<>("product added", HttpStatus.OK);
    }

    public void updateProduct(int id, Product product) {
        productRepo.save(product);
    }

    public ResponseEntity<String> deleteProduct(int id) {
        productRepo.deleteById(id);
        return new ResponseEntity<>("product deleted" , HttpStatus.OK);
    }

}
