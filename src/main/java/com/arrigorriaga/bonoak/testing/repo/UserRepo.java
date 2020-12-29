package com.arrigorriaga.bonoak.testing.repo;

import com.arrigorriaga.bonoak.testing.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {


}
