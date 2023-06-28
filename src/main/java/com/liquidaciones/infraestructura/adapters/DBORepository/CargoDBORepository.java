package com.liquidaciones.infraestructura.adapters.DBORepository;

import com.liquidaciones.infraestructura.adapters.entity.CargoDBO;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoDBORepository extends ReactiveCrudRepository<CargoDBO, Integer> {
}
