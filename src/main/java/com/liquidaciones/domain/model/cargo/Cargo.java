package com.liquidaciones.domain.model.cargo;

import org.springframework.data.annotation.Id;

public class Cargo {

    @Id
    private IdCargo id_cargo;
    private Roll roll;

    public Cargo(IdCargo id_cargo, Roll roll) {
        this.id_cargo = id_cargo;
        this.roll = roll;
    }

    public IdCargo getId_cargo() {
        return id_cargo;
    }

    public Roll getRoll() {
        return roll;
    }

}
