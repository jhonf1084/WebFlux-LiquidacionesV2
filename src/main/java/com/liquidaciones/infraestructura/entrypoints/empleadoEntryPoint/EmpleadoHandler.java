package com.liquidaciones.infraestructura.entrypoints.empleadoEntryPoint;


import com.liquidaciones.domain.usecase.EmpleadoUseCase;
import com.liquidaciones.infraestructura.entrypoints.empleadoEntryPoint.dto.EmpleadoDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class EmpleadoHandler {

    private final EmpleadoUseCase empleadoUseCase;

    public Mono<ServerResponse> crearEmpleado(ServerRequest serverRequest) {
        return serverRequest
                .bodyToMono(EmpleadoDTO.class)
                .flatMap(empleadoDTO -> empleadoUseCase
                        .crearEmpleado(empleadoDTO)
                        .flatMap(savedEmpleado -> ServerResponse
                                .status(HttpStatus.CREATED)
                                .bodyValue(savedEmpleado)))
                .onErrorResume(exception -> ServerResponse
                        .badRequest()
                        .bodyValue(exception.getMessage()));
    }


    public Mono<ServerResponse> getEmpleadoById(ServerRequest serverRequest) {
        Integer id = Integer.valueOf(serverRequest.pathVariable("id"));
        return empleadoUseCase
                .getEmpleadoById(id)
                .flatMap(empleado -> ServerResponse
                        .ok()
                        .bodyValue(empleado))
                .switchIfEmpty(ServerResponse
                        .status(HttpStatus.NO_CONTENT)
                        .bodyValue("El empleados no se encuentra registrado"));
    }


    public Mono<ServerResponse> actualizarEmpleado (ServerRequest serverRequest ){
        return serverRequest
                .bodyToMono(EmpleadoDTO.class)
                .flatMap(empleadoDTO -> empleadoUseCase
                        .actualizarEmpleado(empleadoDTO)
                        .flatMap(savedEmpleado -> ServerResponse
                                .status(HttpStatus.CREATED)
                                .bodyValue(EmpleadoDTO.fromDomain(savedEmpleado))))
                .onErrorResume(exception -> ServerResponse
                        .badRequest()
                        .bodyValue(exception.getMessage()));
    }

    public Mono<ServerResponse> eliminarEmpleado(ServerRequest serverRequest) {
        Integer id = Integer.valueOf(serverRequest.pathVariable("id"));
        return empleadoUseCase
                .eliminarEmpleado(id)
                .flatMap(empleado -> ServerResponse
                        .ok()
                        .bodyValue(empleado))
                .switchIfEmpty(ServerResponse
                        .notFound()
                        .build());
    }


    public Mono<ServerResponse> getEmpleados(ServerRequest serverRequest) {
        return empleadoUseCase
                .getEmpleados()
                .collectList()
                .flatMap(empleados -> ServerResponse
                        .ok()
                        .bodyValue(empleados))
                .switchIfEmpty(ServerResponse
                        .status(HttpStatus.NO_CONTENT)
                        .bodyValue("No hay empleados registrados"));
    }

}
