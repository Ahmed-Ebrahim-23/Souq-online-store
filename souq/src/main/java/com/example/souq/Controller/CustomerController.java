package com.example.souq.Controller;


import com.example.souq.Model.Entity.Customer;
import com.example.souq.Service.CustomerService;
import com.example.souq.exception.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/getAll")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @PutMapping("update/{id}")
    public void updateCustomer(@PathVariable int id, @RequestBody Customer customer) throws CustomerNotFoundException {
        customerService.updateCustomer(id, customer);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addCustomer(@RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCustomerById(@RequestParam int id) {
        return customerService.deleteCustomer(id);
    }
}
