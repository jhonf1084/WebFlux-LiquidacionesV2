package com.liquidaciones.infraestructura.adapters.DBORepository;

import com.liquidaciones.infraestructura.adapters.entity.LiquidacionDBO;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LiquidacionDBORepository extends ReactiveCrudRepository<LiquidacionDBO, Integer> {
}
