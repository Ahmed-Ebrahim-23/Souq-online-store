package com.example.souq.Service;

import com.example.souq.Model.Entity.Supplier;
import com.example.souq.Model.Repo.SupplierRepo;
import com.example.souq.exception.SupplierNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {
    @Autowired
    private SupplierRepo supplierRepo;

    public List<Supplier> getAllSuppliers() {
        List<Supplier> suppliers = (List<Supplier>) supplierRepo.findAll();
        return suppliers;
    }

    public ResponseEntity<String> addSupplier(Supplier supplier) {
        supplierRepo.save(supplier);
        return new ResponseEntity<>("supplier added", HttpStatus.OK);
    }

    public void updateSupplier(int id, Supplier updatedSupplier) throws SupplierNotFoundException {
        Supplier supplier = supplierRepo.findById(id).orElseThrow(() -> new SupplierNotFoundException());

        supplier.setAddress(updatedSupplier.getAddress());
        supplier.setAge(updatedSupplier.getAge());
        supplier.setName(updatedSupplier.getName());
        supplier.setEmail(updatedSupplier.getEmail());
        supplier.setBirthdate(updatedSupplier.getBirthdate());
        supplier.setPhone(updatedSupplier.getPhone());
        supplier.setPassword(updatedSupplier.getPassword());

        supplierRepo.save(supplier);
    }


    public ResponseEntity<String> deleteSupplier(int id) {
        supplierRepo.deleteById(id);
        return new ResponseEntity<>("supplier deleted" , HttpStatus.OK);
    }
}
