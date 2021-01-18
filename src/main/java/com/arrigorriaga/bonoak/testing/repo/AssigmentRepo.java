package com.arrigorriaga.bonoak.testing.repo;

import com.arrigorriaga.bonoak.testing.model.Assigment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssigmentRepo extends JpaRepository<Assigment, Integer> {
}
