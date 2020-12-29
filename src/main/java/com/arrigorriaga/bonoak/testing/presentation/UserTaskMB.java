package com.arrigorriaga.bonoak.testing.presentation;

import com.arrigorriaga.bonoak.testing.model.Coupon;
import com.arrigorriaga.bonoak.testing.service.CouponService;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class UserTaskMB implements Serializable {
    private static final long serialVersionUID = 1L;

    @EJB
    private CouponService couponService;

    public void addCoupon(UserFormMB userFormMB, UserViewMB userViewMB){
        Coupon coupon = new Coupon(userFormMB.getId(), userFormMB.getType(), userFormMB.getPrice(), userFormMB.getClientId());
        couponService.createCoupon(coupon);
        userViewMB.resetView();
    }
}
