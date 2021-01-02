package com.arrigorriaga.bonoak.testing.service;

import com.arrigorriaga.bonoak.testing.model.Role;
import com.arrigorriaga.bonoak.testing.repo.RoleRepo;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.List;

@Service
@Data
@NoArgsConstructor
@LocalBean
@Stateless
public class RoleService {

    private RoleRepo roleRepo;

    @Autowired
    public RoleService(RoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }

    public List<Role> findAllRoles(){
        return roleRepo.findAll();
    }
}
