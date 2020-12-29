package com.arrigorriaga.bonoak.testing.repo;

import com.arrigorriaga.bonoak.testing.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepo extends JpaRepository<Admin, Integer> {
}
