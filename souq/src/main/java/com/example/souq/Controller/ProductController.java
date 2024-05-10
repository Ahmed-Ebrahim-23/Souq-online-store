package com.example.souq.Controller;

import com.example.souq.Class.DTO.ProductDTO;
import com.example.souq.Service.ProductService;
import com.example.souq.exeption.ProductNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public void addProduct(@RequestBody @Valid ProductDTO product) {
        productService.addProduct(product);
    }

    @GetMapping("/getAll")
    public List<ProductDTO> getAllProducts() {
        return productService.getAllProducts();
    }

    @PutMapping("update/{id}")
    public void updateProduct(@PathVariable int id, @RequestBody @Valid ProductDTO product) throws ProductNotFoundException {
        productService.updateProduct(id, product);
    }

    @DeleteMapping("delete/{id}")
    public void deleteProduct(@PathVariable int id) throws ProductNotFoundException {
        productService.deleteProduct(id);
    }

}
