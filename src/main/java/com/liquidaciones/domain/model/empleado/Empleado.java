package com.liquidaciones.domain.model.empleado;

import org.springframework.data.annotation.Id;



public class Empleado {

    @Id
    private Integer id_empleado;
    private IdDocumento documento;
    private NombreApellidos nombre_apellidos;

    private FechaContrato fecha_contrato;



    public Empleado(IdDocumento documento, NombreApellidos nombre_apellidos, FechaContrato fecha_contrato) {
        this.documento = documento;
        this.nombre_apellidos = nombre_apellidos;
        this.fecha_contrato = fecha_contrato;
    }

    public IdDocumento getDocumento() {
        return documento;
    }

    public NombreApellidos getNombre_apellidos() {
        return nombre_apellidos;
    }

    public FechaContrato getFecha_contrato() {
        return fecha_contrato;
    }
}
