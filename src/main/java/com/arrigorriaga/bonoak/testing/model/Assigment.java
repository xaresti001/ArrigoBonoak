package com.arrigorriaga.bonoak.testing.model;

import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data

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
}
