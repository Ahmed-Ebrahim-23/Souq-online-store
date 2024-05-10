package com.example.souq.Service;

import com.example.souq.Class.DTO.CustomerDTO;
import com.example.souq.Model.Entity.Address;
import com.example.souq.Model.Entity.Customer;
import com.example.souq.Model.Repo.CustomerRepo;
import com.example.souq.exeption.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepo customerRepo; // Changed from SupplierRepo to CustomerRepo

    public List<CustomerDTO> getAllCustomers() {
        List<Customer> customers = customerRepo.findAll();
        return CustomerDTO.toCustomerDTOList(customers);
    }

    public void addCustomer(CustomerDTO customer) {
        customerRepo.save(Customer.toCustomer(customer));
    }

    public void updateCustomer(int id, CustomerDTO updatedCustomer) throws CustomerNotFoundException {
        Customer customer = customerRepo.findById(id).orElseThrow(() -> new CustomerNotFoundException("The address with id: " + id + " is not found"));

        customer.setAddress(Address.toAddress(updatedCustomer.getAddress()));
        customer.setAge(updatedCustomer.getAge());
        customer.setName(updatedCustomer.getName());
        customer.setEmail(updatedCustomer.getEmail());
        customer.setBirthdate(updatedCustomer.getBirthdate());
        customer.setPhone(updatedCustomer.getPhone());
        customer.setPassword(updatedCustomer.getPassword());
        customer.setCart(updatedCustomer.getCart());

        customerRepo.save(customer);
    }

    public void deleteCustomer(int id) throws CustomerNotFoundException {
        Customer customer = customerRepo.findById(id).orElseThrow(() -> new CustomerNotFoundException("The address with id: " + id + " is not found"));
        customerRepo.deleteById(id);
    }
}
