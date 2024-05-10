package com.example.souq.Controller;

import com.example.souq.Class.DTO.SupplierDTO;
import com.example.souq.Service.SupplierService;
import com.example.souq.exeption.SupplierNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("supplier")
public class SupplierController {

        @Autowired
        private SupplierService supplierService;

        @GetMapping("/getAll")
        public List<SupplierDTO> getAllSuppliers() {
                return supplierService.getAllSuppliers();
        }

        @PutMapping("update/{id}")
        public void updateSupplier(@PathVariable int id, @RequestBody @Valid SupplierDTO supplier) throws SupplierNotFoundException {
                supplierService.updateSupplier(id, supplier);
        }

        @PostMapping("/add")
        public void addSupplier(@RequestBody @Valid SupplierDTO supplier) {
                supplierService.addSupplier(supplier);
        }

        @DeleteMapping("/delete/{id}")
        public void deleteSupplierById(@RequestParam int id) throws SupplierNotFoundException {
                supplierService.deleteSupplier(id);
        }

}
