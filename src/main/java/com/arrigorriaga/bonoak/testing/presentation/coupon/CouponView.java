package com.arrigorriaga.bonoak.testing.presentation.coupon;

import com.arrigorriaga.bonoak.testing.model.Coupon;
import com.arrigorriaga.bonoak.testing.service.CouponService;
import lombok.Data;

import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Data
@Named
@ViewScoped
public class CouponView implements Serializable {

    private List<Coupon> coupons;
    private List<Coupon> assignedCoupons;
    private List<Coupon> couponsByClientId;

    @EJB
    private CouponService couponService;

    public List<Coupon> findAllCoupons(){
        if(coupons == null){
            coupons = couponService.findAllCoupons();
        }
        return coupons;
    }

    public List<Coupon> findAssignedCoupons(){
        if(assignedCoupons == null){
            assignedCoupons = couponService.findAssignedCoupons();
        }
        return assignedCoupons;
    }

    public void resetView(){
        coupons = null;
        assignedCoupons = null;
        couponsByClientId = null;
    }

    public List<Coupon> findCouponsByClientId(CouponTask couponTask){
        if(couponsByClientId == null){
            couponsByClientId = couponService.findCouponsByClientId(couponTask.getClientId());
        }
        return couponsByClientId;
    }


}
