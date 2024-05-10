package com.example.souq.Controller;


import com.example.souq.Class.DTO.CustomerDTO;
import com.example.souq.Model.Entity.Customer;
import com.example.souq.Service.CustomerService;
import com.example.souq.exeption.CustomerNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/getAll")
    public List<CustomerDTO> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @PutMapping("update/{id}")
    public void updateCustomer(@PathVariable int id, @RequestBody @Valid CustomerDTO customer) throws CustomerNotFoundException {
        customerService.updateCustomer(id, customer);
    }

    @PostMapping("/add")
    public void addCustomer(@RequestBody @Valid CustomerDTO customer) {
        customerService.addCustomer(customer);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCustomerById(@RequestParam int id) throws CustomerNotFoundException {
        customerService.deleteCustomer(id);
    }
}
