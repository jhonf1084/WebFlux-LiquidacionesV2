package com.liquidaciones.aplicacion.configuracion;

import com.liquidaciones.domain.model.gateways.LiquidacionRepository;
import com.liquidaciones.domain.usecase.LiquidacionUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LiquidacionUseCaseBeanConfig {

    @Bean
    public LiquidacionUseCase liquidacionUseCase(LiquidacionRepository liquidacionRepository) {
        return new LiquidacionUseCase(liquidacionRepository);
    }

}
