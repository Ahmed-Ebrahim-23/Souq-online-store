package com.example.souq.Service;

import com.example.souq.Model.Entity.Customer;
import com.example.souq.Model.Repo.CustomerRepo;
import com.example.souq.exception.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepo customerRepo; // Changed from SupplierRepo to CustomerRepo

    public List<Customer> getAllCustomers() {
        List<Customer> customers = (List<Customer>) customerRepo.findAll();
        return customers;
    }

    public ResponseEntity<String> addCustomer(Customer customer) {
        customerRepo.save(customer);
        return new ResponseEntity<>("Customer added", HttpStatus.OK);
    }

    public void updateCustomer(int id, Customer updatedCustomer) throws CustomerNotFoundException {
        Customer customer = customerRepo.findById(id).orElseThrow(() -> new CustomerNotFoundException());

        customer.setAddress(updatedCustomer.getAddress());
        customer.setAge(updatedCustomer.getAge());
        customer.setName(updatedCustomer.getName());
        customer.setEmail(updatedCustomer.getEmail());
        customer.setBirthdate(updatedCustomer.getBirthdate());
        customer.setPhone(updatedCustomer.getPhone());
        customer.setPassword(updatedCustomer.getPassword());
        customer.setCart(updatedCustomer.getCart());

        customerRepo.save(customer);
    }

    public ResponseEntity<String> deleteCustomer(int id) {
        customerRepo.deleteById(id);
        return new ResponseEntity<>("Customer deleted", HttpStatus.OK);
    }
}
