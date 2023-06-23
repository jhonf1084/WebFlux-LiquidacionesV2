package com.liquidaciones.aplicacion.configuracion;

import com.liquidaciones.domain.model.gateways.EmpleadoRepository;
import com.liquidaciones.domain.usecase.EmpleadoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class empleadoUseCaseBeanConfig {

    @Bean
    public EmpleadoUseCase empleadoUseCase(EmpleadoRepository empleadoRepository) {
        return new EmpleadoUseCase(empleadoRepository);
    }

}
