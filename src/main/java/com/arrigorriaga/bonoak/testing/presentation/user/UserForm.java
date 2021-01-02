package com.arrigorriaga.bonoak.testing.presentation.user;

import com.arrigorriaga.bonoak.testing.service.CouponService;
import lombok.Data;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Named
@RequestScoped
public class UserForm implements Serializable {
    private int id;
    private String name;
    private String lastName;
    private String role;
    private int roleId;

}
