package com.arrigorriaga.bonoak.testing.service;

import com.arrigorriaga.bonoak.testing.model.Role;
import com.arrigorriaga.bonoak.testing.model.User;
import com.arrigorriaga.bonoak.testing.repo.RoleRepo;
import com.arrigorriaga.bonoak.testing.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.List;
import java.util.Optional;

@Service
@LocalBean
@Stateless
public class UserService {

    private final UserRepo userRepo;
    private final RoleRepo roleRepo;

    @Autowired
    public UserService(UserRepo userRepo, RoleRepo roleRepo) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
    }

    public User findUserById(int id){
        Optional<User> temp;
        User user = null;
        temp = userRepo.findById(id);
        if(temp.isPresent()){
            user = temp.get();
        }
        return user;
    }

    public boolean deleteUserById(int id){
        boolean control = false;
        if(userRepo.existsById(id)){
            userRepo.deleteById(id);
            control = true;
        }
        return control;
    }

    public User createUser(User newUser){
        User user = null;
        if(!userRepo.existsById(newUser.getId())){
            user = userRepo.save(newUser);
        }
        return user;
    }

    public User updateUser (User updateUser){
        User user = null;
        if(userRepo.existsById(updateUser.getId())){
            user = userRepo.save(updateUser);
        }
        return user;
    }

    public List<User> findAllUsers(){
        return userRepo.findAll();
    }

    public List<User> findAllUsersByRole(String role){
        return userRepo.findUsersByRoleIs(roleRepo.findRoleByRoleNameIs(role));
    }

}
