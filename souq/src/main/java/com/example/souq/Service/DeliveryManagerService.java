package com.example.souq.Service;

import com.example.souq.Model.Entity.DeliveryManager;
import com.example.souq.Model.Repo.DeliveryManagerRepo;
import com.example.souq.exception.DeliveryManagerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryManagerService {
    @Autowired
    private DeliveryManagerRepo deliveryManagerRepo; // Changed from SupplierRepo to DeliveryManagerRepo

    public List<DeliveryManager> getAllDeliveryManagers() {
        List<DeliveryManager> deliveryManagers = deliveryManagerRepo.findAll();
        return deliveryManagers;
    }

    public ResponseEntity<String> addDeliveryManager(DeliveryManager deliveryManager) {
        deliveryManagerRepo.save(deliveryManager);
        return new ResponseEntity<>("DeliveryManager added", HttpStatus.OK);
    }

    public void updateDeliveryManager(int id, DeliveryManager updatedDeliveryManager) throws DeliveryManagerNotFoundException {
        DeliveryManager deliveryManager = deliveryManagerRepo.findById(id).orElseThrow(() -> new DeliveryManagerNotFoundException());

        deliveryManager.setAddress(updatedDeliveryManager.getAddress());
        deliveryManager.setAge(updatedDeliveryManager.getAge());
        deliveryManager.setName(updatedDeliveryManager.getName());
        deliveryManager.setEmail(updatedDeliveryManager.getEmail());
        deliveryManager.setBirthdate(updatedDeliveryManager.getBirthdate());
        deliveryManager.setPhone(updatedDeliveryManager.getPhone());
        deliveryManager.setPassword(updatedDeliveryManager.getPassword());
        deliveryManager.setRole(updatedDeliveryManager.getRole());

        deliveryManagerRepo.save(deliveryManager);
    }

    public ResponseEntity<String> deleteDeliveryManager(int id) {
        deliveryManagerRepo.deleteById(id);
        return new ResponseEntity<>("DeliveryManager deleted", HttpStatus.OK);
    }
}
