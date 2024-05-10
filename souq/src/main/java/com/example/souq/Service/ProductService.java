package com.example.souq.Service;

import com.example.souq.Class.DTO.ProductDTO;
import com.example.souq.Model.Entity.*;
import com.example.souq.Model.Repo.ProductRepo;
import com.example.souq.exeption.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import java.util.Optional;


import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;


    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepo.findAll();
        return ProductDTO.toProductDTOList(products);
    }


    public void addProduct(ProductDTO product) {
        productRepo.save(Product.toProduct(product));
    }

    public void updateProduct(int id, ProductDTO updatedProduct) throws ProductNotFoundException {
        Product product = productRepo.findById(id).orElseThrow(() -> new ProductNotFoundException("The product with id: " + id + " is not found"));

        product.setSupplier(Supplier.toSupplier(updatedProduct.getSupplier()));
        product.setImage(updatedProduct.getImage());
        product.setPrice(updatedProduct.getPrice());
        product.setDescription(updatedProduct.getDescription());
        product.setCategory(Category.toCategory(updatedProduct.getCategory()));
        product.setName(updatedProduct.getName());
        product.setQuantity(updatedProduct.getQuantity());

        productRepo.save(product);
    }

    public void deleteProduct(int id) throws ProductNotFoundException {
        Product product = productRepo.findById(id).orElseThrow(() -> new ProductNotFoundException("The product with id: " + id + " is not found"));
        productRepo.deleteById(id);
    }

}
