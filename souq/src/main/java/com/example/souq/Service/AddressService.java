package com.example.souq.Service;

import com.example.souq.Class.DTO.AddressDTO;
import com.example.souq.Model.Entity.Address;
import com.example.souq.Model.Repo.AddressRepo;
import com.example.souq.exeption.AddressNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressService {
    @Autowired()
    private AddressRepo addressRepo;

    public List<AddressDTO> getAllAddresses() {
        List<Address> addresses = addressRepo.findAll();

        return AddressDTO.toAddressDTOList(addresses);
    }


    public void addAddress(AddressDTO addressDTO) {
        addressRepo.save(Address.toAddress(addressDTO));
    }

    public void updateAddress(int id, AddressDTO updatedAddress) throws AddressNotFoundException {
        Address address = addressRepo.findById(id).orElseThrow(() -> new AddressNotFoundException("The address with id: " + id + " is not found"));

        address.setCity(updatedAddress.getCity());
        address.setCountry(updatedAddress.getCountry());
        address.setStreet(updatedAddress.getStreet());
        address.setApartmentNumber(updatedAddress.getApartmentNumber());

        addressRepo.save(address);
    }

    public void deleteAddress(int id) throws AddressNotFoundException {
        Address address = addressRepo.findById(id).orElseThrow(() -> new AddressNotFoundException("The address with id: " + id + " is not found"));
        addressRepo.deleteById(id);
    }
}
