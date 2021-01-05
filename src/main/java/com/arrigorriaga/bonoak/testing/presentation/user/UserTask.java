package com.arrigorriaga.bonoak.testing.presentation.user;

import com.arrigorriaga.bonoak.testing.model.Role;
import com.arrigorriaga.bonoak.testing.model.User;
import com.arrigorriaga.bonoak.testing.service.RoleService;
import com.arrigorriaga.bonoak.testing.service.UserService;
import lombok.Data;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;


@Data
@Named
@SessionScoped
public class UserTask implements Serializable {

    @EJB
    private UserService userService;
    @EJB
    private RoleService roleService;

    private String message;

    private boolean showUpdateUserName;
    private boolean showUpdateUserLastName;
    private boolean showUpdateUserRole;
    private String searchRole;

    private int userId;



    public void deleteUser(User user, UserView userView){
        boolean control = userService.deleteUserById(user.getId());
        if(control){
            message = "User deleted successfully.";
        }else{
            message = "User not found. Could not be deleted.";
        }
        userView.resetView();
    }

    public void createUser(UserForm userForm, UserView userView) {
        Role role = userView.getRoleMenu().get(userForm.getRoleId());
        userForm.setRole(role.getRoleName());

        User user = new User(userForm.getId(), userForm.getName(), userForm.getLastName(), userForm.getRole());
        User control = userService.createUser(user);
        if (control == null) {
            message = "User already existing. Error while creating the user.";
        } else {
            message = "User created successfully.";
        }
        userForm.crearForm();
        userView.resetView();
    }

    public void changeUserName(UserForm userForm, User user, UserView userView){
        user.setName(userForm.getName());
        User temp = userService.updateUser(user);
        if(temp == null){
            message = "An error occurred while updating the User ID";
        }else{
            message = "User updated successfully";
        }
        showUpdateUserName = false;
        userView.resetView();
    }

    public void changeUserLastName(UserForm userForm, User user, UserView userView){
        user.setLastName(userForm.getLastName());
        User temp = userService.updateUser(user);
        if(temp == null){
            message = "An error occurred while updating the User ID";
        }else{
            message = "User updated successfully";
        }
        showUpdateUserLastName = false;
        userView.resetView();
    }

    public void changeUserRole(UserForm userForm, User user, UserView userView){
        Role role = userView.getRoleMenu().get(userForm.getRoleId());
        userForm.setRole(role.getRoleName());
        user.setRole(userForm.getRole());
        User temp = userService.updateUser(user);
        if(temp == null){
            message = "An error occurred while updating the User ID";
        }else{
            message = "User updated successfully";
        }

        userView.resetView();
    }

    public void setRoleForUserSearch(UserForm userForm, UserView userView){
        Role role = userView.getRoleMenu().get(userForm.getRoleId());
        userForm.setRole(role.getRoleName());
        searchRole = userForm.getRole();
        showUpdateUserLastName = false;
        userView.resetView();
    }

    public void findUserById(UserForm userForm, UserView userView){
        userId = userForm.getId();
        userForm.crearForm();
        userView.resetView();
    }

}
