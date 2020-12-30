package com.arrigorriaga.bonoak.testing.presentation.manager;

import lombok.Data;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;

@Data
@Named
@RequestScoped
public class ManagerForm implements Serializable {
    private int id;
    private int amount;
    private int type;
    private float price;

}
