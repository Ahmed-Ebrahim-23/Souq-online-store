package com.example.souq.Controller;

import com.example.souq.Model.Entity.DeliveryManager;
import com.example.souq.Service.DeliveryManagerService;
import com.example.souq.exeption.DeliveryManagerNotFoundException;
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
    public List<DeliveryManager> getAllDeliveryManagers() {
        return deliveryManagerService.getAllDeliveryManagers();
    }

    @PutMapping("update/{id}")
    public void updateDeliveryManager(@PathVariable int id, @RequestBody DeliveryManager deliveryManager) throws DeliveryManagerNotFoundException {
        deliveryManagerService.updateDeliveryManager(id, deliveryManager);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addDeliveryManager(@RequestBody DeliveryManager deliveryManager) {
        return deliveryManagerService.addDeliveryManager(deliveryManager);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDeliveryManagerById(@RequestParam int id) {
        return deliveryManagerService.deleteDeliveryManager(id);
    }
}
