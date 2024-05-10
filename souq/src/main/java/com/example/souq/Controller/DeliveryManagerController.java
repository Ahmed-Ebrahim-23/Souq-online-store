package com.example.souq.Controller;

import com.example.souq.Class.DTO.DeliveryManagerDTO;
import com.example.souq.Model.Entity.DeliveryManager;
import com.example.souq.Service.DeliveryManagerService;
import com.example.souq.exeption.DeliveryManagerNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("deliveryManager")
public class DeliveryManagerController {
    @Autowired
    private DeliveryManagerService deliveryManagerService;

    @GetMapping("/getAll")
    public List<DeliveryManagerDTO> getAllDeliveryManagers() {
        return deliveryManagerService.getAllDeliveryManagers();
    }

    @PutMapping("update/{id}")
    public void updateDeliveryManager(@PathVariable int id, @RequestBody @Valid DeliveryManagerDTO deliveryManager) throws DeliveryManagerNotFoundException {
        deliveryManagerService.updateDeliveryManager(id, deliveryManager);
    }

    @PostMapping("/add")
    public void addDeliveryManager(@RequestBody @Valid DeliveryManagerDTO deliveryManager) {
        deliveryManagerService.addDeliveryManager(deliveryManager);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteDeliveryManagerById(@RequestParam int id) throws DeliveryManagerNotFoundException {
        deliveryManagerService.deleteDeliveryManager(id);
    }
}
