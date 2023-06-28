package com.liquidaciones.domain.model.gateways;

import com.liquidaciones.domain.model.cargo.Cargo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CargoRepository {

    Mono<Cargo> saveCargo(Cargo cargo);

    Mono<Cargo> findByIdCargo(Integer id_cargo);
    Mono<Cargo> updateCargo(Cargo cargo);
    Mono<Cargo> deleteCargo(Integer id_cargo);

    Flux<Cargo>findAllCargos();

}
