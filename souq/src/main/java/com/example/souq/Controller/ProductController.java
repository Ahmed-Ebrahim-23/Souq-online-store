package com.example.souq.Controller;

import com.example.souq.Model.Entity.Product;
import com.example.souq.Service.ProductService;
import com.example.souq.exeption.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public ResponseEntity<String> addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @GetMapping("/getAll")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PutMapping("update/{id}")
    public void updateProduct(@PathVariable int id, @RequestBody Product product) throws UserNotFoundException {
        productService.updateProduct(id, product);
    }

    @DeleteMapping("delete/{id}")
    public void deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
    }

}
