package com.liquidaciones.infraestructura.entrypoints.empleadoEntryPoint;

import com.liquidaciones.domain.usecase.LiquidacionUseCase;
import com.liquidaciones.infraestructura.entrypoints.empleadoEntryPoint.dto.LiquidacionDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class LiquidacionHandler {

    private final LiquidacionUseCase liquidacionUseCase;

    public Mono<ServerResponse> crearLiquidacion(ServerRequest serverRequest) {
        return serverRequest
                .bodyToMono(LiquidacionDTO.class)
                .flatMap(liquidacionDTO -> liquidacionUseCase
                        .crearLiquidacion(liquidacionDTO)
                        .flatMap(savedLiquidacion -> ServerResponse
                                .status(HttpStatus.CREATED)
                                .bodyValue(savedLiquidacion)))
                .onErrorResume(exception -> ServerResponse
                        .badRequest()
                        .bodyValue(exception.getMessage()));
    }

    public Mono<ServerResponse> getLiquidacionById(ServerRequest serverRequest) {
        Integer id = Integer.valueOf(serverRequest.pathVariable("id"));
        return liquidacionUseCase
                .getLiquidacionById(id)
                .flatMap(liquidacion -> ServerResponse
                        .ok()
                        .bodyValue(liquidacion))
                .switchIfEmpty(ServerResponse
                        .status(HttpStatus.NO_CONTENT)
                        .bodyValue("La liquidacion no se encuentra registrada"));
    }

    public Mono<ServerResponse> actualizarLiquidacion(ServerRequest serverRequest) {
        return serverRequest
                .bodyToMono(LiquidacionDTO.class)
                .flatMap(liquidacionDTO -> liquidacionUseCase
                        .actualizarLiquidacion(liquidacionDTO)
                        .flatMap(savedLiquidacion -> ServerResponse
                                .status(HttpStatus.CREATED)
                                .bodyValue(savedLiquidacion)))
                .onErrorResume(exception -> ServerResponse
                        .badRequest()
                        .bodyValue(exception.getMessage()));
    }

    public Mono<ServerResponse> eliminarLiquidacion(ServerRequest serverRequest) {
        Integer id = Integer.valueOf(serverRequest.pathVariable("id"));
        return liquidacionUseCase
                .eliminarLiquidacion(id)
                .flatMap(liquidacion -> ServerResponse
                        .ok()
                        .bodyValue(liquidacion))
                .switchIfEmpty(ServerResponse
                        .status(HttpStatus.NO_CONTENT)
                        .bodyValue("La liquidacion no se encuentra registrada"));
    }

    public Mono<ServerResponse> getLiquidaciones(ServerRequest serverRequest) {
        return liquidacionUseCase
                .getLiquidaciones()
                .collectList()
                .flatMap(liquidaciones -> ServerResponse
                        .ok()
                        .bodyValue(liquidaciones))
                .switchIfEmpty(ServerResponse
                        .status(HttpStatus.NO_CONTENT)
                        .bodyValue("No hay liquidaciones registradas"));
    }



}
