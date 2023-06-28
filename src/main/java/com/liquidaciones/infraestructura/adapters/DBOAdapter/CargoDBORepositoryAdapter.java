package com.liquidaciones.infraestructura.adapters.DBOAdapter;

import com.liquidaciones.domain.model.cargo.Cargo;
import com.liquidaciones.domain.model.gateways.CargoRepository;
import com.liquidaciones.infraestructura.adapters.DBORepository.CargoDBORepository;
import com.liquidaciones.infraestructura.adapters.entity.CargoDBO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@AllArgsConstructor
public class CargoDBORepositoryAdapter implements CargoRepository {

     private final CargoDBORepository cargoDBORepository;

     @Override
     public Mono<Cargo> saveCargo(Cargo cargo) {
          return cargoDBORepository.save(CargoDBO.fromDomain(cargo)).map(CargoDBO::toDomain);
     }

     @Override
     public Mono<Cargo> findByIdCargo(Integer id_cargo) {
          return cargoDBORepository.findById(id_cargo).map(CargoDBO::toDomain);
     }

     @Override
     public Mono<Cargo> updateCargo(Cargo cargo) {

          return cargoDBORepository.save(CargoDBO.fromDomain(cargo)).map(CargoDBO::toDomain);
     }

     @Override
     public Mono<Cargo> deleteCargo(Integer id_cargo) {

          return cargoDBORepository.findById(id_cargo)
                  .flatMap(cargo -> cargoDBORepository.delete(cargo)
                          .then(Mono.just(cargo.toDomain(cargo))));
     }

     @Override
     public Flux<Cargo> findAllCargos() {

          return cargoDBORepository.findAll().map(CargoDBO::toDomain);
     }
}
