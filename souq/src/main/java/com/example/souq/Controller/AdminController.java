package com.example.souq.Controller;

import com.example.souq.Class.DTO.AdminDTO;
import com.example.souq.Model.Entity.Admin;
import com.example.souq.Service.AdminService;
import com.example.souq.exeption.AdminNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping("/getAll")
    public List<AdminDTO> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    @PutMapping("update/{id}")
    public void updateAdmin(@PathVariable int id, @RequestBody @Valid AdminDTO adminDTO) throws AdminNotFoundException {
        adminService.updateAdmin(id, adminDTO);
    }

    @PostMapping("/add")
    public ResponseEntity<Admin> addAdmin(@RequestBody @Valid AdminDTO adminDTO) {
        Admin savedAdmin = adminService.addAdmin(adminDTO);
        return new ResponseEntity<>(savedAdmin, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAdminById(@PathVariable int id) throws AdminNotFoundException {
        adminService.deleteAdmin(id);
    }
}
