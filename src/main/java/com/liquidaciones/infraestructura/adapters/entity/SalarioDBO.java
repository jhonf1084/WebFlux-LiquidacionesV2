package com.liquidaciones.infraestructura.adapters.entity;

import com.liquidaciones.domain.model.salario.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@Table(name = "salarios")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SalarioDBO {

    @Id
    private Integer id_salario;
    private Integer fk_id_empleado;
    private Double sueldo;
    private Double auxilio_transporte;
    private Integer fk_id_cargo;
    private LocalDate fecha_modificacion;

    public static SalarioDBO fromDomain(Salario salario){
        System.out.println(salario.toString());
        return SalarioDBO.builder()
                .id_salario(salario.getId_salario().getValue())
                .fk_id_empleado(salario.getFk_id_empleado().getValue())
                .sueldo(salario.getSueldo().getValue())
                .auxilio_transporte(salario.getAuxilio_transporte().getValue())
                .fk_id_cargo(salario.getFk_id_cargo().getValue())
                .fecha_modificacion(salario.getFecha_modificacion().getValue())
                .build();
    }


    public static Salario toDomain (SalarioDBO salarioDBO ){
        return new Salario(
                IdSalario.builder().value(salarioDBO.id_salario).build(),
                FkIdEmpleado.builder().value(salarioDBO.fk_id_empleado).build(),
                Sueldo.builder().value(salarioDBO.sueldo).build(),
                AuxilioTransporte.builder().value(salarioDBO.auxilio_transporte).build(),
                FkIdCargo.builder().value(salarioDBO.fk_id_cargo).build(),
                FechaModificacion.builder().value(salarioDBO.fecha_modificacion).build());
    }

    public Integer getId_salario() {
        return id_salario;
    }

    public Integer getFk_id_empleado() {
        return fk_id_empleado;
    }

    public Double getSueldo() {
        return sueldo;
    }

    public Double getAuxilio_transporte() {
        return auxilio_transporte;
    }

    public Integer getFk_id_cargo() {
        return fk_id_cargo;
    }

    public LocalDate getFecha_modificacion() {
        return fecha_modificacion;
    }
}
