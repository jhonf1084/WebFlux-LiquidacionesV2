package com.liquidaciones.infraestructura.adapters.DBOAdapter;

import com.liquidaciones.domain.model.empleado.Empleado;
import com.liquidaciones.domain.model.gateways.EmpleadoRepository;
import com.liquidaciones.infraestructura.adapters.DBORepository.EmpleadoDBORepository;
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
    public Mono<Empleado> saveEmpleado(Empleado empleado) {
        return empleadoDBORepository.save(EmpleadoDBO.fromDomain(empleado)).map(EmpleadoDBO::toDomain);
    }

    @Override
    public Mono<Empleado> findByIdEmpleado(Integer id) {
        return empleadoDBORepository.findById(id).map(EmpleadoDBO::toDomain);
    }

    @Override
    public Mono<Empleado> updateEmpleado(Empleado empleado) {
        EmpleadoDBO empleadoDBO = EmpleadoDBO.fromDomain(empleado);
        return empleadoDBORepository.save(empleadoDBO).map(EmpleadoDBO::toDomain);
    }

    @Override
    public Mono<Empleado> deleteEmpleado(Integer id) {
        return empleadoDBORepository.findById(id)
                .flatMap(empleado -> empleadoDBORepository.delete(empleado)
                        .then(Mono.just(empleado.toDomain(empleado))));
    }

    @Override
    public Flux<Empleado> findAllEmpleados() {
        return empleadoDBORepository.findAll().map(EmpleadoDBO::toDomain);
    }
}
