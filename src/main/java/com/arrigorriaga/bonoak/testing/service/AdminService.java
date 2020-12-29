package com.arrigorriaga.bonoak.testing.service;

import com.arrigorriaga.bonoak.testing.model.Admin;
import com.arrigorriaga.bonoak.testing.repo.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import java.util.List;
import java.util.Optional;

@LocalBean
@Stateless
@Service
public class AdminService {

    private final AdminRepo adminRepo;

    @Autowired
    public AdminService(AdminRepo adminRepo) {
        this.adminRepo = adminRepo;
    }

    public Admin findAdminById(int id){
        Optional<Admin> temp;
        Admin admin = null;
        temp = adminRepo.findById(id);
        if(temp.isPresent()){
            admin = temp.get();
        }
        return admin;
    }

    public Admin createAdmin(Admin newAdmin){
        Admin admin = null;
        if(!adminRepo.existsById(newAdmin.getId())){
            admin = newAdmin;
            //admin.setPass(passEncoder(admin.getPass()));
            adminRepo.save(admin);
        }
        return admin; //PROBLEMA DE SEGURIDAD, ESTAMOS DEVOLVIENDO EL HASH DE LA CONTRASEÑA
    }

    public boolean deleteAdminById(int id){
        boolean control = false;
        if(adminRepo.existsById(id)){
            adminRepo.deleteById(id);
            control = true;
        }
        return control;
    }

    public List<Admin> findAllAdmins(){
        return adminRepo.findAll();
    }


    public Admin changeAdminPasswordById(int id, String newPasword){
        Admin admin = null;
        if(adminRepo.existsById(id)){
            admin = findAdminById(id); //BÚSQUEDA REDUNDANTE. LA BÚSQUEDA SE HACE DOS VECES
            admin.setPass(newPasword);
            adminRepo.save(admin);
        }
        return admin;
    }

/*
    public String passEncoder(String rawPass){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(rawPass);
    }

    public boolean passChecker(String rawPass, String encodedPass){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(rawPass,encodedPass);
    }



    public boolean adminLogin(int id, String pass){
        boolean control = false;
        Optional<Admin> temp = adminRepo.findById(id);
        if(temp.isPresent() && pass.equals(temp.get().getPass())){
            control=true;
        }
        return control;
    }
     */

    public boolean adminLogin(int id, String password){
        boolean control = false;
        Admin admin = null;
        Optional<Admin> tempAdmin = adminRepo.findById(id);
        if(tempAdmin.isPresent()){
            admin = tempAdmin.get();
            //control = passChecker(password, admin.getPass());
            control = true;
        }

        return control;
    }

}
