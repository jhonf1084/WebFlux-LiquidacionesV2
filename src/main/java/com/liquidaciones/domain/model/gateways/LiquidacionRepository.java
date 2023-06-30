package com.liquidaciones.domain.model.gateways;

import com.liquidaciones.domain.model.liquidacion.Liquidacion;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface LiquidacionRepository {

    Mono<Liquidacion> saveLiquidacion(Liquidacion liquidacion);
    Mono<Liquidacion> findByIdLiquidacion(Integer id_liquidacion);

    Mono<Liquidacion> updateLiquidacion(Liquidacion liquidacion);
    Mono<Liquidacion> deleteLiquidacion(Integer id_liquidacion);

    Flux<Liquidacion>findAllLiquidaciones();


}
