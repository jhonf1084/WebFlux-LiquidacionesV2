package com.liquidaciones.domain.model.salario;

import org.springframework.data.annotation.Id;

public class Salario {

    @Id
    private IdSalario id_salario;
    private FkIdEmpleado fk_id_empleado;
    private Sueldo sueldo;
    private AuxilioTransporte auxilio_transporte;
    private FkIdCargo fk_id_cargo;
    private FechaModificacion fecha_modificacion;


    public Salario(IdSalario id_salario, FkIdEmpleado fk_id_empleado, Sueldo sueldo, AuxilioTransporte auxilio_transporte, FkIdCargo fk_id_cargo, FechaModificacion fecha_modificacion) {
        this.id_salario = id_salario;
        this.fk_id_empleado = fk_id_empleado;
        this.sueldo = sueldo;
        this.auxilio_transporte = auxilio_transporte;
        this.fk_id_cargo = fk_id_cargo;
        this.fecha_modificacion = fecha_modificacion;
    }

    public IdSalario getId_salario() {
        return id_salario;
    }

    public FkIdEmpleado getFk_id_empleado() {
        return fk_id_empleado;
    }

    public Sueldo getSueldo() {
        return sueldo;
    }

    public AuxilioTransporte getAuxilio_transporte() {
        return auxilio_transporte;
    }

    public FkIdCargo getFk_id_cargo() {
        return fk_id_cargo;
    }

    public FechaModificacion getFecha_modificacion() {
        return fecha_modificacion;
    }
}
