package com.arrigorriaga.bonoak.testing.presentation.coupon;

import com.arrigorriaga.bonoak.testing.presentation.manager.ManagerForm;
import com.arrigorriaga.bonoak.testing.service.CouponService;
import lombok.Data;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Data
@Named
@SessionScoped
public class CouponTask implements Serializable {

    @EJB
    private CouponService couponService;
    private String message;

    public void createSetOfCoupons(CouponForm couponForm, CouponView couponView){
        boolean control = couponService.createSetOfCoupons(couponForm);
        if(control){
            message = "An error occurred while creating the Set Of Coupons. Some of the coupons where already created in the DataBase.";
        }else{
            message = "Set Of Coupons created successfully!";
        }
        couponView.resetView();

    }
}
