package com.example.souq.Service;

import com.example.souq.Model.Entity.Address;
import com.example.souq.Model.Repo.AddressRepo;
import com.example.souq.exception.AddressNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    private AddressRepo addressRepo;

    public List<Address> getAllAddresses() {
        List<Address> addresses = addressRepo.findAll();
        return addresses;
    }


    public Address addAddress(Address address) {
        Address savedAddress = addressRepo.save(address);
        return savedAddress;
    }

    public void updateAddress(int id, Address updatedAddress) throws AddressNotFoundException {
        Address address = addressRepo.findById(id).orElseThrow(() -> new AddressNotFoundException());

        address.setCity(updatedAddress.getCity());
        address.setCountry(updatedAddress.getCountry());
        address.setStreet(updatedAddress.getStreet());
        address.setApartmentNumber(updatedAddress.getApartmentNumber());

        addressRepo.save(address);
    }

    public ResponseEntity<String> deleteAddress(int id) {
        addressRepo.deleteById(id);
        return new ResponseEntity<>("address deleted" , HttpStatus.OK);
    }
}
