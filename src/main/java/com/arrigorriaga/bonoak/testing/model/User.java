package com.arrigorriaga.bonoak.testing.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class User {

    @Id
    private int id;
    private String name;
    private String lastName;
    private LocalDateTime registrationTime = LocalDateTime.now();
    //private String role;

    public User(int id, String name, String lastName, Role role) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.role = role;
    }

    @ManyToOne
    private Role role;
}
