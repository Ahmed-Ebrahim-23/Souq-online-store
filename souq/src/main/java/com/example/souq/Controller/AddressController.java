package com.example.souq.Controller;

import com.example.souq.Class.DTO.AddressDTO;
import com.example.souq.Model.Entity.Address;
import com.example.souq.Service.AddressService;
import com.example.souq.exeption.AddressNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @PostMapping("/add")
    public void addAddress(@RequestBody @Valid AddressDTO addressDTO) {
        addressService.addAddress(addressDTO);
    }

    @GetMapping("/getAll")
    public List<AddressDTO> getAllAddresses() {
        return addressService.getAllAddresses();
    }

    @PutMapping("/update/{id}")
    public void updateAddress(@PathVariable int id, @RequestBody @Valid AddressDTO address) throws AddressNotFoundException {
        addressService.updateAddress(id, address);
    }

    @DeleteMapping("delete/{id}")
    public void deleteAddress(@PathVariable int id) throws AddressNotFoundException {
        addressService.deleteAddress(id);
    }

}
