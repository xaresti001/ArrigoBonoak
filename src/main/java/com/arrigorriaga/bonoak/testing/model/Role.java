package com.arrigorriaga.bonoak.testing.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Role {

    @Id
    private int roleId;
    private String roleName;
}
