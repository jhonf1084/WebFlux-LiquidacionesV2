package com.liquidaciones.domain.model.cargo;

import org.springframework.data.annotation.Id;

public class Cargo {

    @Id
    private Integer id_cargo;
    private Roll roll;

    public Cargo(Roll roll) {
        this.roll = roll;
    }

    public Integer getId_cargo() {
        return id_cargo;
    }

    public Roll getRoll() {
        return roll;
    }
}
