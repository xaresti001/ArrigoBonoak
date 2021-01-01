package com.arrigorriaga.bonoak.testing.presentation.coupon;

import lombok.Data;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Data
@Named
@RequestScoped
public class CouponForm {
    private int id;
    private int amount;
    private int type;
    private float price;
    private int clientId;
}
