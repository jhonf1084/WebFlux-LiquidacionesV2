package com.liquidaciones.infraestructura.entrypoints.empleadoEntryPoint.dto;

import com.liquidaciones.domain.model.salario.*;
import com.liquidaciones.infraestructura.adapters.entity.SalarioDBO;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

public class SalarioDTO {

    @Id
    private Integer id_salario;
    private Integer fk_id_empleado;
    private Float sueldo;
    private Float auxilio_transporte;
    private Integer fk_id_cargo;
    private LocalDate fecha_modificacion;

    public Salario toDomain() {
        return new Salario(
                IdSalario.builder().value(id_salario).build(),
                FkIdEmpleado.builder().value(fk_id_empleado).build(),
                Sueldo.builder().value(sueldo).build(),
                AuxilioTransporte.builder().value(auxilio_transporte).build(),
                FkIdCargo.builder().value(fk_id_cargo).build(),
                FechaModificacion.builder().value(fecha_modificacion).build());
    }


    public static SalarioDTO fromDomain(Salario salario) {
        return new SalarioDTO(
                salario.getId_salario().getValue(),
                salario.getFk_id_empleado().getValue(),
                salario.getSueldo().getValue(),
                salario.getAuxilio_transporte().getValue(),
                salario.getFk_id_cargo().getValue(),
                salario.getFecha_modificacion().getValue());
    }

    public SalarioDTO(Integer id_salario, Integer fk_id_empleado, Float sueldo, Float auxilio_transporte, Integer fk_id_cargo, LocalDate fecha_modificacion) {
        this.id_salario = id_salario;
        this.fk_id_empleado = fk_id_empleado;
        this.sueldo = sueldo;
        this.auxilio_transporte = auxilio_transporte;
        this.fk_id_cargo = fk_id_cargo;
        this.fecha_modificacion = fecha_modificacion;
    }

    public Integer getId_salario() {
        return id_salario;
    }

    public Integer getFk_id_empleado() {
        return fk_id_empleado;
    }

    public Float getSueldo() {
        return sueldo;
    }

    public Float getAuxilio_transporte() {
        return auxilio_transporte;
    }

    public Integer getFk_id_cargo() {
        return fk_id_cargo;
    }

    public LocalDate getFecha_modificacion() {
        return fecha_modificacion;
    }
}
