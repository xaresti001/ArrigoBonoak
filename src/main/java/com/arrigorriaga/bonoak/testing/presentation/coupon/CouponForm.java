package com.arrigorriaga.bonoak.testing.presentation.coupon;

import lombok.Data;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;

@Data
@Named
@RequestScoped
public class CouponForm implements Serializable {
    private int id;
    private int amount;
    private int type;
    private float price;
    private int clientId;
}
