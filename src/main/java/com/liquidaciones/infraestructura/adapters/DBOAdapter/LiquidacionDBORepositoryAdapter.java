package com.liquidaciones.infraestructura.adapters.DBOAdapter;

import com.liquidaciones.domain.model.gateways.LiquidacionRepository;
import com.liquidaciones.domain.model.liquidacion.Liquidacion;
import com.liquidaciones.infraestructura.adapters.DBORepository.LiquidacionDBORepository;
import com.liquidaciones.infraestructura.adapters.entity.LiquidacionDBO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@AllArgsConstructor
public class LiquidacionDBORepositoryAdapter implements LiquidacionRepository {

    private final LiquidacionDBORepository liquidacionDBORepository;


    @Override
    public Mono<Liquidacion> saveLiquidacion(Liquidacion liquidacion) {
        return liquidacionDBORepository.save(LiquidacionDBO.fromDomain(liquidacion)).map(LiquidacionDBO::toDomain);
    }

    @Override
    public Mono<Liquidacion> findByIdLiquidacion(Integer id_liquidacion) {
        return liquidacionDBORepository.findById(id_liquidacion).map(LiquidacionDBO::toDomain);
    }

    @Override
    public Mono<Liquidacion> updateLiquidacion(Liquidacion liquidacion) {
        return liquidacionDBORepository.save(LiquidacionDBO.fromDomain(liquidacion)).map(LiquidacionDBO::toDomain);
    }

    @Override
    public Mono<Liquidacion> deleteLiquidacion(Integer id_liquidacion) {
        return liquidacionDBORepository.findById(id_liquidacion)
                .flatMap(liquidacion -> liquidacionDBORepository.delete(liquidacion)
                        .then(Mono.just(liquidacion.toDomain(liquidacion))));
    }

    @Override
    public Flux<Liquidacion> findAllLiquidaciones() {
        return liquidacionDBORepository.findAll().map(LiquidacionDBO::toDomain);
    }
}
