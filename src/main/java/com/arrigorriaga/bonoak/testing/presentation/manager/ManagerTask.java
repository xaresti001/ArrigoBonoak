package com.arrigorriaga.bonoak.testing.presentation.manager;


import com.arrigorriaga.bonoak.testing.service.CouponService;
import lombok.Data;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Data
@Named
@SessionScoped
public class ManagerTask implements Serializable {

    @EJB
    private CouponService couponService;
    private String message;

    public void createSetOfCoupons(ManagerForm managerForm, ManagerView managerView){
        boolean control = couponService.createSetOfCoupons(managerForm);
        if(control){
            message = "An error occurred while creating the Set Of Coupons. Some of the coupons where already created in the DataBase.";
        }else{
            message = "Set Of Coupons created successfully!";
        }
        managerView.resetView();

    }


}
