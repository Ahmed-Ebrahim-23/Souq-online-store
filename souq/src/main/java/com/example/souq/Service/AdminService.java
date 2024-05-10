package com.example.souq.Service;

import com.example.souq.Class.DTO.AdminDTO;
import com.example.souq.Model.Entity.Address;
import com.example.souq.Model.Entity.Admin;
import com.example.souq.Model.Repo.AdminRepo;
import com.example.souq.exeption.AdminNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private AdminRepo adminRepo;

    public List<AdminDTO> getAllAdmins() {
        List<Admin> admins = adminRepo.findAll();
        return AdminDTO.toAdminDTOList(admins);
    }

    public Admin addAdmin(AdminDTO adminDTO) {
        return adminRepo.save(Admin.toAdmin(adminDTO));
    }

    public void updateAdmin(int id, AdminDTO updatedAdmin) throws AdminNotFoundException {
        Admin admin = adminRepo.findById(id).orElseThrow(() -> new AdminNotFoundException("The admin with id: " + id + " is not found"));

        admin.setAddress(Address.toAddress(updatedAdmin.getAddress()));
        admin.setAge(updatedAdmin.getAge());
        admin.setName(updatedAdmin.getName());
        admin.setEmail(updatedAdmin.getEmail());
        admin.setBirthdate(updatedAdmin.getBirthdate());
        admin.setPhone(updatedAdmin.getPhone());
        admin.setPassword(updatedAdmin.getPassword());
        admin.setRole(updatedAdmin.getRole());

        adminRepo.save(admin);
    }


    public void deleteAdmin(int id) throws AdminNotFoundException {
        Admin admin = adminRepo.findById(id).orElseThrow(() -> new AdminNotFoundException("The admin with id: " + id + " is not found"));
        adminRepo.deleteById(id);
    }
}
