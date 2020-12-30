package com.arrigorriaga.bonoak.testing.presentation.manager;

import com.arrigorriaga.bonoak.testing.model.Coupon;
import com.arrigorriaga.bonoak.testing.service.CouponService;
import lombok.Data;


import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@ViewScoped
@Named
public class ManagerView implements Serializable {

    private List<Coupon> coupon;
    private List<Coupon> selectedCoupon;
    private int show = 0;
    private List<Coupon> temp;
    @EJB
    private CouponService couponService;

    public List<Coupon> findAllCoupons(){
        if(coupon == null){
            coupon = couponService.findAllCoupons();
        }
        return coupon;
    }




    public void resetView(){
        coupon = null;
    }




}
