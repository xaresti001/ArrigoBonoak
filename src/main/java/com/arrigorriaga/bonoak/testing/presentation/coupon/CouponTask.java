package com.arrigorriaga.bonoak.testing.presentation.coupon;

import com.arrigorriaga.bonoak.testing.model.Coupon;
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
    private int clientId = 0;

    public void createSetOfCoupons(CouponForm couponForm, CouponView couponView){
        boolean control = couponService.createSetOfCoupons(couponForm);
        if(control){
            message = "Some of the coupons where already created in the DataBase.";
        }else{
            message = "Set Of Coupons created successfully!";
        }
        couponView.resetView();
    }

    public void deleteCoupon (Coupon coupon, CouponView couponView){
        boolean control = couponService.deleteCouponById(coupon.getId());
        if(!control){
            message = "An error occurred while trying to delete Coupon.";
        }else{
            message = "Coupon deleted successfully!";
        }
        couponView.resetView();
    }

    public void setClientIdForCouponSearch(CouponForm couponForm, CouponView couponView){
        clientId = couponForm.getClientId();
        couponView.resetView();
    }
}
