package com.liquidaciones.infraestructura.adapters;

import com.liquidaciones.infraestructura.adapters.entity.EmpleadoDBO;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoDBORepository extends ReactiveCrudRepository<EmpleadoDBO, Integer> {
}
