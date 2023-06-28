package com.liquidaciones.infraestructura.adapters.DBORepository;

import com.liquidaciones.infraestructura.adapters.entity.SalarioDBO;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalarioDBORepository extends ReactiveCrudRepository<SalarioDBO, Integer> {
}
