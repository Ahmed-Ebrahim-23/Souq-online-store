package com.example.souq.Controller;

import com.example.souq.Model.Entity.Address;
import com.example.souq.Service.AddressService;
import com.example.souq.exception.AddressNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @PostMapping("/add")
    public Address addAddress(@RequestBody Address address) {
        return addressService.addAddress(address);
    }

    @GetMapping("/getAll")
    public List<Address> getAllAddresses() {
        return addressService.getAllAddresses();
    }

    @PutMapping("update/{id}")
    public void updateAddress(@PathVariable int id, @RequestBody Address address) throws AddressNotFoundException {
        addressService.updateAddress(id, address);
    }

    @DeleteMapping("delete/{id}")
    public void deleteAddress(@PathVariable int id) {
        addressService.deleteAddress(id);

    }

}
