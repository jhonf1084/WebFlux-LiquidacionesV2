package com.liquidaciones.infraestructura.entrypoints.empleadoEntryPoint;

import com.liquidaciones.domain.usecase.SalarioUseCase;
import com.liquidaciones.infraestructura.entrypoints.empleadoEntryPoint.dto.SalarioDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class SalarioHandler {

    private final SalarioUseCase salarioUseCase;


    public Mono<ServerResponse> crearSalario(ServerRequest serverRequest) {
        return serverRequest
                .bodyToMono(SalarioDTO.class)
                .flatMap(salarioDTO -> salarioUseCase
                        .crearSalario(salarioDTO)
                        .flatMap(savedSalario -> ServerResponse
                                .status(HttpStatus.CREATED)
                                .bodyValue(savedSalario)))
                .onErrorResume(exception -> ServerResponse
                        .badRequest()
                        .bodyValue(exception.getMessage()));
    }
    //Reemplazar el badRequest por un status(HttpStatus.NO_CONTENT)
    public Mono<ServerResponse> getSalarioById(ServerRequest serverRequest) {
        Integer id = Integer.valueOf(serverRequest.pathVariable("id"));
        return salarioUseCase
                .getSalarioById(id)
                .flatMap(salario -> ServerResponse
                        .ok()
                        .bodyValue(salario))
                .switchIfEmpty(ServerResponse
                        .badRequest()
                        .bodyValue("El salario no se encuentra registrado"));
    }

    //Este metodo queda diferente al de actualizar empleado
    public Mono<ServerResponse> actualizarSalario(ServerRequest serverRequest) {
        Integer id = Integer.parseInt(serverRequest.pathVariable("id"));
        return salarioUseCase
                .getSalarioById(id)
                .flatMap(salario -> serverRequest
                        .bodyToMono(SalarioDTO.class)
                        .flatMap(salarioDTO -> salarioUseCase
                                .actualizarSalario(salarioDTO)
                                .flatMap(savedSalario -> ServerResponse
                                        .ok()
                                        .bodyValue(savedSalario))))
                .onErrorResume(exception -> ServerResponse
                        .badRequest()
                        .bodyValue(exception.getMessage()));
    }

    public Mono<ServerResponse> eliminarSalario(ServerRequest serverRequest) {
        Integer id = Integer.valueOf(serverRequest.pathVariable("id"));
        return salarioUseCase
                .eliminarSalario(id)
                .flatMap(salario -> ServerResponse
                        .ok()
                        .bodyValue(salario))
                .switchIfEmpty(ServerResponse
                        .notFound()
                        .build());
    }

    public Mono<ServerResponse> getSalarios(ServerRequest serverRequest) {
        return salarioUseCase
                .getSalarios()
                .collectList()
                .flatMap(salarios -> ServerResponse
                        .ok()
                        .bodyValue(salarios))
                .switchIfEmpty(ServerResponse
                        .status(HttpStatus.NO_CONTENT)
                        .bodyValue("No hay empleados registrados"));
    }



}
