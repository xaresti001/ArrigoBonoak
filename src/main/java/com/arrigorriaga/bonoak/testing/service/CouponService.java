package com.arrigorriaga.bonoak.testing.service;

import com.arrigorriaga.bonoak.testing.model.Coupon;
import com.arrigorriaga.bonoak.testing.presentation.coupon.CouponForm;
import com.arrigorriaga.bonoak.testing.presentation.manager.ManagerForm;
import com.arrigorriaga.bonoak.testing.repo.CouponRepo;
import com.arrigorriaga.bonoak.testing.repo.UserRepo;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.List;
import java.util.Optional;

@Data
@NoArgsConstructor
@LocalBean
@Stateless
@Service
public class CouponService {

    private CouponRepo couponRepo;
    private UserRepo userRepo;

    @Autowired
    public CouponService(CouponRepo couponRepo, UserRepo userRepo) {
        this.couponRepo = couponRepo;
        this.userRepo = userRepo;
    }

    public Coupon findCouponById(int id){
        Optional<Coupon> temp;
        Coupon coupon = null;
        temp = couponRepo.findById(id);
        if(temp.isPresent()){
            coupon = temp.get();
        }
        return coupon;
    }

    public boolean deleteCouponById(int id){
        boolean control = false;
        if(couponRepo.existsById(id)){
            couponRepo.deleteById(id);
            control = true;
        }
        return control;
    }

    public Coupon createCoupon(Coupon newCoupon){
        Coupon coupon = null;
        if(!couponRepo.existsById(newCoupon.getId())){
            coupon = couponRepo.save(newCoupon);
        }
        return coupon;
    }

    public Coupon updateCoupon (Coupon updateCoupon){
        Coupon coupon = null;
        if(couponRepo.existsById(updateCoupon.getId())){
            coupon = couponRepo.save(updateCoupon);
        }
        return coupon;
    }

    public boolean createSetOfCoupons(CouponForm couponForm){
        boolean control = false;
        Coupon temp;
        for(int i = 0; i<couponForm.getAmount(); i++){
            temp = new Coupon(couponForm.getId()+i, couponForm.getType(), couponForm.getPrice(), 0);
            if(createCoupon(temp)==null){
                control = true;
            }
        }
        return control;
    }

    public List<Coupon> findAllCoupons(){
        return couponRepo.findAll();
    }

    public List<Coupon> findAssignedCoupons(){
        return couponRepo.findCouponsByClientIdIsGreaterThan(0);
    }

    public List<Coupon> findCouponsByClientId(int clientId){
        return couponRepo.findCouponsByClientIdIs(clientId);
    }

}
