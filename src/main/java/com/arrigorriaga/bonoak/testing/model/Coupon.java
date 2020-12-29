package com.arrigorriaga.bonoak.testing.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Coupon {

    @Id
    private int id;
    private int type;
    private float price;
    private int clientId;
    private LocalDateTime buyingTime = LocalDateTime.now();

    public Coupon(int id, int type, float price, int clientId) {
        this.id = id;
        this.type = type;
        this.price = price;
        this.clientId = clientId;
    }
}
