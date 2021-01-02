package com.arrigorriaga.bonoak.testing.presentation.user;

import com.arrigorriaga.bonoak.testing.model.Role;
import com.arrigorriaga.bonoak.testing.model.User;
import com.arrigorriaga.bonoak.testing.service.RoleService;
import com.arrigorriaga.bonoak.testing.service.UserService;
import lombok.Data;

import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Data
@Named
@ViewScoped
public class UserView {

    @EJB
    private UserService userService;
    @EJB
    private RoleService roleService;

    private List<User> allUsers;
    private List<User> allUsersByRole;

    private List<Role> roleMenu;
    private Map<Integer, Role> roleMenuMap;

    public List<User> findAllUsers(){
        if(allUsers == null){
            allUsers = userService.findAllUsers();
        }
        return allUsers;
    }

    public List<User> findAllUsersByRole(String role){
        if(allUsersByRole == null){
            allUsersByRole = userService.findAllUsersByRole(role);
        }
        return allUsersByRole;
    }

    public void resetView(){
        allUsers = null;
        allUsersByRole = null;
        roleMenu = null;
        roleMenuMap = null;
    }

    public Collection<Role> findUserRoleMenu() {
        if(roleMenuMap == null) {
            roleMenuMap = new LinkedHashMap<Integer, Role>();
            roleMenu = roleService.findAllRoles();
            Role tempRole;
            for(int i=0;i<roleMenu.size();i++) {
                tempRole=roleMenu.get(i);
                roleMenuMap.put(tempRole.getRoleId(), tempRole);
            }
        }
        return roleMenuMap.values();
    }
}
