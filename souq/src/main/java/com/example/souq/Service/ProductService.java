package com.example.souq.Service;

import com.example.souq.Model.Entity.Product;
import com.example.souq.Model.Repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;

    public ResponseEntity<String> addProduct(Product product) {
        productRepo.save(product);
        return new ResponseEntity<>("product added", HttpStatus.OK);
    }

}
