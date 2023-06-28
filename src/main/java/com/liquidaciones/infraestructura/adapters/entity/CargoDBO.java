package com.liquidaciones.infraestructura.adapters.entity;

import com.liquidaciones.domain.model.cargo.Cargo;
import com.liquidaciones.domain.model.cargo.IdCargo;
import com.liquidaciones.domain.model.cargo.Roll;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "cargos")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CargoDBO {

    @Id
    private Integer id_cargo;
    private String roll;


    public static CargoDBO fromDomain(Cargo cargo){
        return CargoDBO.builder()
                .id_cargo(cargo.getId_cargo().getValue())
                .roll(cargo.getRoll().getValue())
                .build();
    }

    public static Cargo toDomain(CargoDBO cargoDBO){
        return new Cargo(
                IdCargo.builder().value(cargoDBO.id_cargo).build(),
                Roll.builder().value(cargoDBO.roll).build());
    }

    public Integer getId_cargo() {
        return id_cargo;
    }

    public String getRoll() {
        return roll;
    }
}
