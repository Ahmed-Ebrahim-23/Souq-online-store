package com.example.souq.Controller;

import com.example.souq.Model.Entity.ProductManager;
import com.example.souq.Service.ProductManagerService;
import com.example.souq.exception.ProductManagerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("ProductManager")
public class ProductManagerController {
    @Autowired
    private ProductManagerService productManagerService;

    @GetMapping("/getAll")
    public List<ProductManager> getAllProductManagers() {
        return productManagerService.getAllProductManagers();
    }

    @PutMapping("update/{id}")
    public void updateProductManager(@PathVariable int id, @RequestBody ProductManager productManager) throws ProductManagerNotFoundException {
        productManagerService.updateProductManager(id, productManager);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addProductManager(@RequestBody ProductManager productManager) {
        return productManagerService.addProductManager(productManager);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProductManagerById(@RequestParam int id) {
        return productManagerService.deleteProductManager(id);
    }
}
