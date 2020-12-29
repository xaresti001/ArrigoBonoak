package com.arrigorriaga.bonoak.testing.service;

import com.arrigorriaga.bonoak.testing.model.Coupon;
import com.arrigorriaga.bonoak.testing.repo.CouponRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CouponService {

    private final CouponRepo couponRepo;

    @Autowired
    public CouponService(CouponRepo couponRepo) {
        this.couponRepo = couponRepo;
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

    public List<Coupon> findAllCoupons(){
        return couponRepo.findAll();
    }
}
