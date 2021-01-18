package com.arrigorriaga.bonoak.testing.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Assigment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int assigmentId;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Coupon coupon;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    private LocalDateTime assigmentDate = LocalDateTime.now();

    public Assigment(Coupon coupon, User user) {
        this.coupon = coupon;
        this.user = user;
    }
}
