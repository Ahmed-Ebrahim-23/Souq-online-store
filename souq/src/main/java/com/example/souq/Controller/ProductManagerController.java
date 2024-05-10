package com.example.souq.Controller;

import com.example.souq.Class.DTO.ProductManagerDTO;
import com.example.souq.Model.Entity.ProductManager;
import com.example.souq.Service.ProductManagerService;
import com.example.souq.exeption.ProductManagerNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("productManager")
public class ProductManagerController {
    @Autowired
    private ProductManagerService productManagerService;

    @GetMapping("/getAll")
    public List<ProductManagerDTO> getAllProductManagers() {
        return productManagerService.getAllProductManagers();
    }

    @PutMapping("update/{id}")
    public void updateProductManager(@PathVariable int id, @RequestBody @Valid ProductManagerDTO productManager) throws ProductManagerNotFoundException {
        productManagerService.updateProductManager(id, productManager);
    }

    @PostMapping("/add")
    public void addProductManager(@RequestBody @Valid ProductManagerDTO productManager) {
        productManagerService.addProductManager(productManager);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProductManagerById(@RequestParam int id) throws ProductManagerNotFoundException {
        productManagerService.deleteProductManager(id);
    }
}
