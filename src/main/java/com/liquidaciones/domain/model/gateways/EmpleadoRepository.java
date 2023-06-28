package com.liquidaciones.domain.model.gateways;

import com.liquidaciones.domain.model.empleado.Empleado;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EmpleadoRepository {

    Mono<Empleado> saveEmpleado(Empleado empleado);

    Mono<Empleado> findByIdEmpleado(Integer id_empleado);
    Mono<Empleado> updateEmpleado(Empleado empleado);
    Mono<Empleado> deleteEmpleado(Integer id_empleado);
    Flux<Empleado> findAllEmpleados();


}
