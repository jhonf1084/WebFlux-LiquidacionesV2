package com.liquidaciones.aplicacion.configuracion;

import com.liquidaciones.domain.model.gateways.SalarioRepository;
import com.liquidaciones.domain.usecase.SalarioUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SalarioUseCaseBeanConfig {

    @Bean
    public SalarioUseCase salarioUseCase(SalarioRepository salarioRepository) {
        return new SalarioUseCase(salarioRepository);
    }


}
