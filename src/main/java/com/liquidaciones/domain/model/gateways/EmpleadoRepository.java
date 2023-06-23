package com.liquidaciones.domain.model.gateways;

import com.liquidaciones.domain.model.empleado.Empleado;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EmpleadoRepository {

    Mono<Empleado> save(Empleado empleado);

    Mono<Empleado> findById(Integer id_empleado);
    Mono<Empleado> update(Empleado empleado);
    Mono<Empleado> delete(Integer id_empleado);
    Flux<Empleado> findAll();


}
