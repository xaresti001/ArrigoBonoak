package com.arrigorriaga.bonoak.testing.viewController;

import com.arrigorriaga.bonoak.testing.model.User;
import com.arrigorriaga.bonoak.testing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/view")
public class ViewController {
    private final UserService userService;

    @Autowired
    public ViewController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/managerPanel")
    public String managerPanel(ModelMap model){
        return "managerPanel";
    }

    @GetMapping("/managerPanel/allUsers")
    public String getAllUsers(ModelMap model){
        List<User> allUsers = userService.findAllUsers();
        model.addAttribute("allUsers", allUsers);
        return "viewAllUsers";
    }


}
