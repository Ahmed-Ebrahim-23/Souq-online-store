package com.example.souq.Controller;

import com.example.souq.Model.Entity.Supplier;
import com.example.souq.Service.SupplierService;
import com.example.souq.exception.SupplierNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("supplier")
public class SupplierController {

        @Autowired
        private SupplierService supplierService;

        @GetMapping("/getAll")
        public List<Supplier> getAllSuppliers() {
                return supplierService.getAllSuppliers();
        }

        @PutMapping("update/{id}")
        public void updateSupplier(@PathVariable int id, @RequestBody Supplier supplier) throws SupplierNotFoundException {
                supplierService.updateSupplier(id, supplier);
        }

        @PostMapping("/add")
        public ResponseEntity<String> addSupplier(@RequestBody Supplier supplier) {
                return supplierService.addSupplier(supplier);
        }

        @DeleteMapping("/delete/{id}")
        public ResponseEntity<String> deleteSupplierById(@RequestParam int id) {
                return supplierService.deleteSupplier(id);
        }

}
