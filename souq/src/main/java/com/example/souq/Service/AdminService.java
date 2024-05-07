package com.example.souq.Service;

import com.example.souq.Model.Entity.Admin;
import com.example.souq.Model.Repo.AdminRepo;
import com.example.souq.exception.AdminNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    private AdminRepo adminRepo;

    public List<Admin> getAllAdmins() {
        List<Admin> admins = adminRepo.findAll();
        return admins;
    }

    public ResponseEntity<String> addAdmin(Admin admin) {
        adminRepo.save(admin);
        return new ResponseEntity<>("admin added", HttpStatus.OK);
    }

    public void updateAdmin(int id, Admin updatedadmin) throws AdminNotFoundException {
        Admin admin = adminRepo.findById(id).orElseThrow(() -> new AdminNotFoundException());

        admin.setAddress(updatedadmin.getAddress());
        admin.setAge(updatedadmin.getAge());
        admin.setName(updatedadmin.getName());
        admin.setEmail(updatedadmin.getEmail());
        admin.setBirthdate(updatedadmin.getBirthdate());
        admin.setPhone(updatedadmin.getPhone());
        admin.setPassword(updatedadmin.getPassword());

        adminRepo.save(admin);
    }


    public ResponseEntity<String> deleteAdmin(int id) {
        adminRepo.deleteById(id);
        return new ResponseEntity<>("admin deleted" , HttpStatus.OK);
    }
}
