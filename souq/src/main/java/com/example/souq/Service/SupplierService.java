package com.example.souq.Service;

import com.example.souq.Class.DTO.SupplierDTO;
import com.example.souq.Model.Entity.Address;
import com.example.souq.Model.Entity.Product;
import com.example.souq.Model.Entity.Supplier;
import com.example.souq.Model.Repo.SupplierRepo;
import com.example.souq.exeption.AddressNotFoundException;
import com.example.souq.exeption.SupplierNotFoundException;
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

    public List<SupplierDTO> getAllSuppliers() {
        List<Supplier> suppliers = (List<Supplier>) supplierRepo.findAll();
        return SupplierDTO.toAdminDTOList(suppliers);
    }

    public void addSupplier(SupplierDTO supplier) {
        supplierRepo.save(Supplier.toSupplier(supplier));
    }

    public void updateSupplier(int id, SupplierDTO updatedSupplier) throws SupplierNotFoundException {
        Supplier supplier = supplierRepo.findById(id).orElseThrow(() -> new SupplierNotFoundException("The supplier with id: " + id + " is not found"));

        supplier.setAddress(Address.toAddress(updatedSupplier.getAddress()));
        supplier.setAge(updatedSupplier.getAge());
        supplier.setName(updatedSupplier.getName());
        supplier.setEmail(updatedSupplier.getEmail());
        supplier.setBirthdate(updatedSupplier.getBirthdate());
        supplier.setPhone(updatedSupplier.getPhone());
        supplier.setPassword(updatedSupplier.getPassword());

        supplierRepo.save(supplier);
    }


    public void deleteSupplier(int id) throws SupplierNotFoundException {
        Supplier supplier = supplierRepo.findById(id).orElseThrow(() -> new SupplierNotFoundException("The supplier with id: " + id + " is not found"));
        supplierRepo.deleteById(id);
    }
}
