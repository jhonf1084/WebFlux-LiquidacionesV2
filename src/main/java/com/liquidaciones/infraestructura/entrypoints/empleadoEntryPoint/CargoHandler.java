package com.liquidaciones.infraestructura.entrypoints.empleadoEntryPoint;

import com.liquidaciones.domain.usecase.CargoUseCase;
import com.liquidaciones.infraestructura.entrypoints.empleadoEntryPoint.dto.CargoDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.security.PublicKey;

@Component
@AllArgsConstructor
public class CargoHandler {

    private final CargoUseCase cargoUseCase;

    public Mono<ServerResponse> crearCargo (ServerRequest serverRequest){
        return serverRequest
                .bodyToMono(CargoDTO.class)
                .flatMap(cargoDTO -> cargoUseCase
                        .crearCargo(cargoDTO)
                        .flatMap(savedCargo -> ServerResponse
                                .status(HttpStatus.CREATED)
                                .bodyValue(savedCargo)))
                .onErrorResume(exception -> ServerResponse
                        .badRequest()
                        .bodyValue(exception.getMessage()));
    }

    public Mono<ServerResponse> getCargoById(ServerRequest serverRequest) {
        Integer id = Integer.valueOf(serverRequest.pathVariable("id"));
        return cargoUseCase
                .getCargoById(id)
                .flatMap(cargo -> ServerResponse
                        .ok()
                        .bodyValue(cargo))
                .switchIfEmpty(ServerResponse
                        .badRequest()
                        .bodyValue("El cargo no se encuentra registrado"));
    }

    public Mono<ServerResponse> actualizarCargo(ServerRequest serverRequest) {
        return serverRequest
                .bodyToMono(CargoDTO.class)
                .flatMap(cargoDTO -> cargoUseCase
                        .actualizarCargo(cargoDTO)
                        .flatMap(savedCargo -> ServerResponse
                                .status(HttpStatus.CREATED)
                                .bodyValue(savedCargo)))
                .onErrorResume(exception -> ServerResponse
                        .badRequest()
                        .bodyValue(exception.getMessage()));
    }

    public Mono<ServerResponse> eliminarCargo(ServerRequest serverRequest) {
        Integer id = Integer.valueOf(serverRequest.pathVariable("id"));
        return cargoUseCase
                .eliminarCargo(id)
                .flatMap(cargo -> ServerResponse
                        .ok()
                        .bodyValue(cargo))
                .switchIfEmpty(ServerResponse
                        .badRequest()
                        .bodyValue("El cargo no se encuentra registrado"));
    }

    public Mono<ServerResponse> getCargos (ServerRequest serverRequest){
        return cargoUseCase
                .getCargos()
                .collectList()
                .flatMap(cargos -> ServerResponse
                        .ok()
                        .bodyValue(cargos))
                .switchIfEmpty(ServerResponse
                        .status(HttpStatus.NO_CONTENT)
                        .bodyValue("No hay cargos registrados"));
    }



}
