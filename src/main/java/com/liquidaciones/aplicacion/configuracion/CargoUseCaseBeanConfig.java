package com.liquidaciones.aplicacion.configuracion;

import com.liquidaciones.domain.model.gateways.CargoRepository;
import com.liquidaciones.domain.usecase.CargoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CargoUseCaseBeanConfig {

    @Bean
    public CargoUseCase cargoUseCase (CargoRepository cargoRepository) {
        return new CargoUseCase(cargoRepository);
    }

}
