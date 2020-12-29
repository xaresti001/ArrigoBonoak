package com.arrigorriaga.bonoak.testing.presentation;


import lombok.Data;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;

@Data
@Named
@RequestScoped
public class UserFormMB implements Serializable {
    private static final long serialVersionUID = 1L;


    private int id;
    private int type;
    private float price;
    private int clientId;
}
