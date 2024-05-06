package com.example.souq.Service;

import com.example.souq.Model.Entity.Supplier;
import com.example.souq.Model.Repo.SupplierRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example.souq.Service.Validator.isvalidEmail;
import static com.example.souq.Service.Validator.isvalidNumber;

@Service
public class SupplierService {
    @Autowired
    private SupplierRepo supplierRepo;

    public ArrayList<Supplier> getAllSuppliers() {
        ArrayList<Supplier> suppliers = (ArrayList<Supplier>) supplierRepo.findAll();
        System.out.println(suppliers.size());
        return suppliers;
    }

    public Optional<Supplier> getSupplierById(int id) {
        Optional<Supplier> supplier = supplierRepo.findById(id);
        return supplier;
    }

    public ResponseEntity<String> addSupplier(Supplier supplier) {
        supplierRepo.save(supplier);
        return new ResponseEntity<>("supplier added", HttpStatus.OK);
    }

    public ResponseEntity<String> deleteSupplier(int id) {
        supplierRepo.deleteById(id);
        return new ResponseEntity<>("supplier deleted" , HttpStatus.OK);
    }
}
