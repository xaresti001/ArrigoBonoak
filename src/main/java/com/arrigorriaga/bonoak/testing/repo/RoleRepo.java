package com.arrigorriaga.bonoak.testing.repo;

import com.arrigorriaga.bonoak.testing.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Integer> {
    Role findRoleByRoleNameIs(String roleName);
}
