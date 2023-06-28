package com.liquidaciones.domain.model.gateways;

import com.liquidaciones.domain.model.salario.Salario;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SalarioRepository {

    Mono<Salario> saveSalario(Salario salario);

    Mono<Salario> findByIdSalario(Integer id_salario);

    Mono<Salario> updateSalario(Salario salario);

    Mono<Salario> deleteSalario(Integer id_salario);

    Flux<Salario> findAllSalarios();


}
