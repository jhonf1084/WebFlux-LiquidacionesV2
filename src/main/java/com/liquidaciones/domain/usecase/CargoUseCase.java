package com.liquidaciones.domain.usecase;

import com.liquidaciones.domain.model.cargo.Cargo;
import com.liquidaciones.domain.model.gateways.CargoRepository;
import com.liquidaciones.infraestructura.entrypoints.empleadoEntryPoint.dto.CargoDTO;
import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
public class CargoUseCase {

    private final CargoRepository cargoRepository;

    public Mono<Cargo> crearCargo(CargoDTO cargoDTO) {
        Cargo cargo = cargoDTO.toDomain();
        return cargoRepository.saveCargo(cargo);
    }

    public Mono<Cargo> getCargoById(Integer id_cargo) {
        return cargoRepository.findByIdCargo(id_cargo);
    }

    public Mono<Cargo> actualizarCargo(CargoDTO cargoDTO) {
        return cargoRepository.findByIdCargo(cargoDTO.getId_cargo())
                .switchIfEmpty(Mono.error(new ChangeSetPersister.NotFoundException()))
                .flatMap(existingCargo -> cargoRepository.updateCargo(cargoDTO.toDomain())
                        .then(Mono.just(existingCargo))
                );
    }

    public Mono<Cargo> eliminarCargo(Integer id_cargo) {
        return cargoRepository.deleteCargo(id_cargo);
    }

    public Flux<Cargo> getCargos() {
        return cargoRepository.findAllCargos();
    }

}
