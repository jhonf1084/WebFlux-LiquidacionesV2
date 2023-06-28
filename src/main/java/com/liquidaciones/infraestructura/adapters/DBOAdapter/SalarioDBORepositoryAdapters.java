package com.liquidaciones.infraestructura.adapters.DBOAdapter;

import com.liquidaciones.domain.model.gateways.SalarioRepository;
import com.liquidaciones.domain.model.salario.Salario;
import com.liquidaciones.infraestructura.adapters.DBORepository.SalarioDBORepository;
import com.liquidaciones.infraestructura.adapters.entity.SalarioDBO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@AllArgsConstructor
public class SalarioDBORepositoryAdapters implements SalarioRepository {

    private final SalarioDBORepository salarioDBORepository;

    @Override
    public Mono<Salario> saveSalario(Salario salario) {
        return salarioDBORepository.save(SalarioDBO.fromDomain(salario)).map(SalarioDBO::toDomain);
    }

    @Override
    public Mono<Salario> findByIdSalario(Integer id_salario) {
        return salarioDBORepository.findById(id_salario).map(SalarioDBO::toDomain);
    }

    @Override
    public Mono<Salario> updateSalario(Salario salario) {
        return salarioDBORepository.save(SalarioDBO.fromDomain(salario)).map(SalarioDBO::toDomain);
    }

    @Override
    public Mono<Salario> deleteSalario(Integer id_salario) {

        return salarioDBORepository.findById(id_salario)
                .flatMap(salario -> salarioDBORepository.delete(salario)
                        .then(Mono.just(salario.toDomain(salario))));
    }

    @Override
    public Flux<Salario> findAllSalarios() {
    return salarioDBORepository.findAll().map(SalarioDBO::toDomain);
    }
}
