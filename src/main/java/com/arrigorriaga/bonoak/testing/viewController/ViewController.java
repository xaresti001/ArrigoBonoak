package com.arrigorriaga.bonoak.testing.viewController;

import com.arrigorriaga.bonoak.testing.model.Role;
import com.arrigorriaga.bonoak.testing.model.User;
import com.arrigorriaga.bonoak.testing.service.RoleService;
import com.arrigorriaga.bonoak.testing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/view")
public class ViewController {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public ViewController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/managerPanel/")
    public String managerPanel(){
        return "managerPanel";
    }

    @GetMapping("/managerPanel/allUsers/")
    public String getAllUsers(ModelMap model){
        List<User> allUsers = userService.findAllUsers();
        List<Role> allRoles = roleService.findAllRoles();

        model.addAttribute("allRoles", allRoles);
        model.addAttribute("allUsers", allUsers);

        model.addAttribute("userForm", new User());
        model.addAttribute("newUser", new User());
        return "viewAllUsers";
    }


    @GetMapping("/managerPanel/allUsers/searchUser/")
    public String searchUserById(@RequestParam("search") int userId, ModelMap model){
        User searchUser = userService.findUserById(userId);
        model.addAttribute("searchUser", searchUser);
        return "viewSearchUsers";
    }

    @PostMapping("/managerPanel/allUsers/deleteUser/")
    public String deleteUserById(@ModelAttribute("userForm") User user, ModelMap model){
        boolean control = userService.deleteUserById(user.getId());
        System.out.println(control);
        System.out.println(user.getId());
        model.clear();
        return "redirect:/view/managerPanel/allUsers/";
    }

    @PostMapping("/managerPanel/allUsers/createUser/")
    public String createUser(@ModelAttribute User user, ModelMap model){
        userService.createUser(user);
        model.clear();
        return "redirect:/view/managerPanel/allUsers/";
    }

    @GetMapping("/managerPanel/allUsers/updateUser/")
    public String updateUser(@ModelAttribute User user, ModelMap model){
        User tempUser = userService.findUserById(user.getId());
        model.addAttribute("searchUser", tempUser);
        List<Role> allRoles = roleService.findAllRoles();
        model.addAttribute("allRoles", allRoles);

        // En este caso no purgamos la vista, porque queremos mantener el atributo local.
        // El atributo local visualizará en el formulario la información del usuario.
        return "viewUpdateUser";
    }

    @PostMapping("/managerPanel/allUsers/updateUser/update/")
    public String updateUserConfirm(@ModelAttribute("searchUser") User user, ModelMap model){
        userService.updateUser(user);
        model.clear(); // En esta caso purgamos la vista y volvemos al punto de partida.
        return "redirect:/view/managerPanel/allUsers/";
    }




}
