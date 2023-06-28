package com.liquidaciones.infraestructura.entrypoints.empleadoEntryPoint.dto;

import com.liquidaciones.domain.model.cargo.Cargo;
import com.liquidaciones.domain.model.cargo.IdCargo;
import com.liquidaciones.domain.model.cargo.Roll;
import org.springframework.data.annotation.Id;

public class CargoDTO {

    @Id
    private Integer id_cargo;
    private String roll;

    public Cargo toDomain () {
        return new Cargo(
                IdCargo.builder().value(id_cargo).build(),
                Roll.builder().value(roll).build());
    }

    public static CargoDTO fromDomain(Cargo cargo) {
        return new CargoDTO(
                cargo.getId_cargo().getValue(),
                cargo.getRoll().getValue());
    }

    public CargoDTO(Integer id_cargo, String roll) {
        this.id_cargo = id_cargo;
        this.roll = roll;
    }

    public Integer getId_cargo() {
        return id_cargo;
    }

    public String getRoll() {
        return roll;
    }
}
