package com.example.souq.Service;

import com.example.souq.Class.DTO.DeliveryManagerDTO;
import com.example.souq.Model.Entity.Address;
import com.example.souq.Model.Entity.DeliveryManager;
import com.example.souq.Model.Repo.DeliveryManagerRepo;
import com.example.souq.exeption.DeliveryManagerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryManagerService {
    @Autowired
    private DeliveryManagerRepo deliveryManagerRepo; // Changed from SupplierRepo to DeliveryManagerRepo

    public List<DeliveryManagerDTO> getAllDeliveryManagers() {
        List<DeliveryManager> deliveryManagers = deliveryManagerRepo.findAll();
        return DeliveryManagerDTO.toAdminDTOList(deliveryManagers);
    }

    public void addDeliveryManager(DeliveryManagerDTO deliveryManager) {
        deliveryManagerRepo.save(DeliveryManager.toDeliveryManager(deliveryManager));
    }

    public void updateDeliveryManager(int id, DeliveryManagerDTO updatedDeliveryManager) throws DeliveryManagerNotFoundException {
        DeliveryManager deliveryManager = deliveryManagerRepo.findById(id).orElseThrow(() -> new DeliveryManagerNotFoundException("The delivery manager with id: " + id + " is not found"));

        deliveryManager.setAddress(Address.toAddress(updatedDeliveryManager.getAddress()));
        deliveryManager.setAge(updatedDeliveryManager.getAge());
        deliveryManager.setName(updatedDeliveryManager.getName());
        deliveryManager.setEmail(updatedDeliveryManager.getEmail());
        deliveryManager.setBirthdate(updatedDeliveryManager.getBirthdate());
        deliveryManager.setPhone(updatedDeliveryManager.getPhone());
        deliveryManager.setPassword(updatedDeliveryManager.getPassword());
        deliveryManager.setRole(updatedDeliveryManager.getRole());

        deliveryManagerRepo.save(deliveryManager);
    }

    public void deleteDeliveryManager(int id) throws DeliveryManagerNotFoundException {
        DeliveryManager deliveryManager = deliveryManagerRepo.findById(id).orElseThrow(() -> new DeliveryManagerNotFoundException("The delivery manager with id: " + id + " is not found"));
        deliveryManagerRepo.deleteById(id);
    }
}
