package com.arrigorriaga.bonoak.testing.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Admin {

    @Id
    private int id;
    private String name;
    private String lastName;
    private String pass;


}
