package com.liquidaciones.infraestructura.adapters;

import com.liquidaciones.domain.model.empleado.Empleado;
import com.liquidaciones.domain.model.gateways.EmpleadoRepository;
import com.liquidaciones.infraestructura.adapters.entity.EmpleadoDBO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@AllArgsConstructor
public class EmpleadoDBORepositoryAdapter implements EmpleadoRepository {

    private final EmpleadoDBORepository empleadoDBORepository;


    @Override
    public Mono<Empleado> save(Empleado empleado) {
        return empleadoDBORepository.save(EmpleadoDBO.fromDomain(empleado)).map(EmpleadoDBO::toDomain);
    }

    @Override
    public Mono<Empleado> findById(Integer id) {
        return empleadoDBORepository.findById(id).map(EmpleadoDBO::toDomain);
    }

    @Override
    public Mono<Empleado> update(Empleado empleado) {
        EmpleadoDBO empleadoDBO = EmpleadoDBO.fromDomain(empleado);
        return empleadoDBORepository.save(empleadoDBO).map(EmpleadoDBO::toDomain);
    }

    @Override
    public Mono<Empleado> delete(Integer id) {
        return empleadoDBORepository.findById(id)
                .flatMap(empleado -> empleadoDBORepository.delete(empleado)
                        .then(Mono.just(empleado.toDomain(empleado))));
    }

    @Override
    public Flux<Empleado> findAll() {
        return empleadoDBORepository.findAll().map(EmpleadoDBO::toDomain);
    }
}
