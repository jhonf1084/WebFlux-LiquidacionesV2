package com.liquidaciones.domain.usecase;

import com.liquidaciones.domain.model.gateways.LiquidacionRepository;
import com.liquidaciones.domain.model.liquidacion.Liquidacion;
import com.liquidaciones.infraestructura.entrypoints.empleadoEntryPoint.dto.LiquidacionDTO;
import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
public class LiquidacionUseCase {

    private final LiquidacionRepository liquidacionRepository;

   // private Double salarioMinimo = 1160000.0;

    public Mono<Liquidacion> crearLiquidacion(LiquidacionDTO liquidacionDTO) {
        Liquidacion liquidacion = liquidacionDTO.toDomain();
        return liquidacionRepository.saveLiquidacion(liquidacion);
    }

    public Mono<Liquidacion> getLiquidacionById(Integer id_liquidacion) {
        return liquidacionRepository.findByIdLiquidacion(id_liquidacion);
    }

    public Mono<Liquidacion> actualizarLiquidacion(LiquidacionDTO liquidacionDTO) {
        return liquidacionRepository.findByIdLiquidacion(liquidacionDTO.getId_liquidacion())
                .switchIfEmpty(Mono.error(new ChangeSetPersister.NotFoundException()))
                .flatMap(existingLiquidacion -> liquidacionRepository.updateLiquidacion(liquidacionDTO.toDomain())
                        .then(Mono.just(existingLiquidacion))
                );
    }

    public Mono<Liquidacion> eliminarLiquidacion(Integer id_liquidacion) {

        return liquidacionRepository.deleteLiquidacion(id_liquidacion);
    }

    public Flux<Liquidacion> getLiquidaciones() {

        return liquidacionRepository.findAllLiquidaciones();
    }

}
