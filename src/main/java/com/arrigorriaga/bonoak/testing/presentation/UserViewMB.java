package com.arrigorriaga.bonoak.testing.presentation;

import com.arrigorriaga.bonoak.testing.model.Coupon;
import com.arrigorriaga.bonoak.testing.service.CouponService;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Data
@Named
@ViewScoped
public class UserViewMB implements Serializable {
    private static final long serialVersionUID = 1L;


    private List<Coupon> coupons;

    @EJB
    private CouponService couponService;

    public List<Coupon> findAllCoupons(){
        if(coupons == null)
            coupons = couponService.findAllCoupons();
        return coupons;
    }

    public void resetView(){
        this.coupons = null;
    }

}
