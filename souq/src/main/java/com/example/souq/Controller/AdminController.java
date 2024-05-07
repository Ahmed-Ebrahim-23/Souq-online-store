package com.example.souq.Controller;

import com.example.souq.Model.Entity.Admin;
import com.example.souq.Service.AdminService;
import com.example.souq.exeption.AdminNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping("/getAll")
    public List<Admin> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    @PutMapping("update/{id}")
    public void updateAdmin(@PathVariable int id, @RequestBody Admin admin) throws AdminNotFoundException {
        adminService.updateAdmin(id, admin);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addAdmin(@RequestBody Admin admin) {
        return adminService.addAdmin(admin);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAdminById(@RequestParam int id) {
        return adminService.deleteAdmin(id);
    }
}
