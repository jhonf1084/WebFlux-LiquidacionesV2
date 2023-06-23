package com.liquidaciones.infraestructura.adapters.entity;

import com.liquidaciones.domain.model.empleado.Empleado;
import com.liquidaciones.domain.model.empleado.FechaContrato;
import com.liquidaciones.domain.model.empleado.IdDocumento;
import com.liquidaciones.domain.model.empleado.NombreApellidos;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Table(name = "empleados")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmpleadoDBO {

    @Id
    private Integer id_empleado;
    private Integer documento;
    private String nombre_apellidos;
    private LocalDate fecha_contrato;

    public static EmpleadoDBO fromDomain(Empleado empleado){
        System.out.println(empleado.toString());
        return EmpleadoDBO.builder()
                .documento(empleado.getDocumento().getValue())
                .nombre_apellidos(empleado.getNombre_apellidos().getValue())
                .fecha_contrato(empleado.getFecha_contrato().getValue())
                .build();
    }

    public static Empleado toDomain(EmpleadoDBO empleadoDBO){
        return new Empleado(
                IdDocumento.builder().value(empleadoDBO.documento).build(),
                NombreApellidos.builder().value(empleadoDBO.nombre_apellidos).build(),
                FechaContrato.builder().value(empleadoDBO.fecha_contrato).build());
    }

    public Integer getDocumento() {
        return documento;
    }

    public String getNombre_apellidos() {
        return nombre_apellidos;
    }

    public LocalDate getFecha_contrato() {
        return fecha_contrato;
    }
}
