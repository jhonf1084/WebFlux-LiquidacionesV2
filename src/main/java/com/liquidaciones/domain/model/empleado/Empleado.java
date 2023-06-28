package com.liquidaciones.domain.model.empleado;

import org.springframework.data.annotation.Id;



public class Empleado {

    @Id
    private IdEmpleado id_empleado;
    private Documento documento;
    private NombreApellidos nombre_apellidos;

    private FechaContrato fecha_contrato;


    public Empleado(IdEmpleado id_empleado, Documento documento, NombreApellidos nombre_apellidos, FechaContrato fecha_contrato) {
        this.id_empleado = id_empleado;
        this.documento = documento;
        this.nombre_apellidos = nombre_apellidos;
        this.fecha_contrato = fecha_contrato;
    }

    public IdEmpleado getId_empleado() {
        return id_empleado;
    }
    public Documento getDocumento() {
        return documento;
    }

    public NombreApellidos getNombre_apellidos() {
        return nombre_apellidos;
    }

    public FechaContrato getFecha_contrato() {
        return fecha_contrato;
    }
}
