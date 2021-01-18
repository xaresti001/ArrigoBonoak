package com.arrigorriaga.bonoak.testing.controller;

import com.arrigorriaga.bonoak.testing.model.Admin;
import com.arrigorriaga.bonoak.testing.model.User;
import com.arrigorriaga.bonoak.testing.service.AdminService;
import com.arrigorriaga.bonoak.testing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {

    private final UserService userService;
    private final AdminService adminService;

    @Autowired
    public MainController(UserService userService, AdminService adminService) {
        this.userService = userService;
        this.adminService = adminService;
    }






    @PostMapping("/user/create")
    public User createUser(
            @RequestParam("name") String name,
            @RequestParam("lastName") String lastName,
            @RequestParam("id") int id
    ){
        User user = new User(id, name, lastName, null);
        return userService.createUser(user);
    }

    @GetMapping("/user/find")
    public User findUser(
            @RequestParam("id") int id
    ){
        return userService.findUserById(id);
    }

    @PostMapping("/user/delete")
    public void deleteUser(
            @RequestParam("id") int id
    ){
        userService.deleteUserById(id);
    }

    @GetMapping("/user/findAll")
    public List<User> findAllUsers(){
        return userService.findAllUsers();
    }

    @PostMapping("/admin/create")
    public Admin createAdmin(
            @RequestParam("id") int id,
            @RequestParam("name") String name,
            @RequestParam("lastName") String lastName,
            @RequestParam("password") String password
    ){
        Admin admin = new Admin(id,name,lastName,password);
        return adminService.createAdmin(admin);
    }

    @GetMapping("/admin/findAll")
    public List<Admin> findAllAdmins(){
        return adminService.findAllAdmins();
    }
}
