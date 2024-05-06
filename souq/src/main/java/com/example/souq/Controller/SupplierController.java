package com.example.souq.Controller;

import com.example.souq.Model.Entity.Supplier;
import com.example.souq.Service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("supplier")
public class SupplierController {

        @Autowired
        private SupplierService supplierService;

        @GetMapping("/getallsuppliers")
        public ArrayList<Supplier> getAllSuppliers() {
                return supplierService.getAllSuppliers();
        }

        @GetMapping("/getsupplier")
        public Optional<Supplier> getSupplierById(@RequestParam int id) {
                return supplierService.getSupplierById(id);
        }

        @PostMapping("/addsupplier")
        public ResponseEntity<String> addSupplier(@RequestBody Supplier supplier) {
                return supplierService.addSupplier(supplier);
        }

        @DeleteMapping("/deletesupplier")
        public ResponseEntity<String> deleteSupplierById(@RequestParam int id) {
                return supplierService.deleteSupplier(id);
        }

}
