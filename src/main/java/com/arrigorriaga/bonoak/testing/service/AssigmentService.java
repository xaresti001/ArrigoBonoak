package com.arrigorriaga.bonoak.testing.service;

import com.arrigorriaga.bonoak.testing.model.Assigment;
import com.arrigorriaga.bonoak.testing.model.Coupon;
import com.arrigorriaga.bonoak.testing.model.User;
import com.arrigorriaga.bonoak.testing.repo.AssigmentRepo;
import com.arrigorriaga.bonoak.testing.repo.CouponRepo;
import com.arrigorriaga.bonoak.testing.repo.UserRepo;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.List;

@Data
@NoArgsConstructor
@LocalBean
@Stateless
@Service
public class AssigmentService {

    private AssigmentRepo assigmentRepo;
    private UserRepo userRepo;
    private CouponRepo couponRepo;

    @Autowired
    public AssigmentService(AssigmentRepo assigmentRepo, UserRepo userRepo, CouponRepo couponRepo) {
        this.assigmentRepo = assigmentRepo;
        this.userRepo = userRepo;
        this.couponRepo = couponRepo;
    }

    public Assigment createAssigment(Coupon coupon, User user){
        boolean control = false;
        Assigment assigment = null;
        if(userRepo.existsById(user.getId())){
            control = AssigmentConditions(user);
            if(control){
                assigment = new Assigment(coupon, user);
            }
        }
        return assigment;
    }

    private boolean AssigmentConditions(User user){
        boolean control = false;
        List<Coupon> coupons = couponRepo.findCouponsByClientIdIs(user.getId());

    }
}
