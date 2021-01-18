package com.arrigorriaga.bonoak.testing.service;

import com.arrigorriaga.bonoak.testing.repo.AssigmentRepo;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Data
@NoArgsConstructor
@LocalBean
@Stateless
@Service
public class AssigmentService {

    private AssigmentRepo assigmentRepo;

    @Autowired
    public AssigmentService(AssigmentRepo assigmentRepo) {
        this.assigmentRepo = assigmentRepo;
    }

    private boolean CouponConditions(){
        return false;
    }
}
