package com.liquidaciones.domain.usecase;

import com.liquidaciones.domain.model.gateways.SalarioRepository;
import com.liquidaciones.domain.model.salario.Salario;
import com.liquidaciones.infraestructura.entrypoints.empleadoEntryPoint.dto.SalarioDTO;
import lombok.AllArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
public class SalarioUseCase {

    private final SalarioRepository salarioRepository;

    public Mono<Salario> crearSalario(SalarioDTO salarioDTO) {
        Salario salario = salarioDTO.toDomain();
        return salarioRepository.saveSalario(salario);
    }

    public Mono<Salario> getSalarioById(Integer id_salario) {
        return salarioRepository.findByIdSalario(id_salario);
    }


    public Mono<Salario> actualizarSalario(SalarioDTO salarioDTO) {
        return salarioRepository.findByIdSalario(salarioDTO.getId_salario())
                .switchIfEmpty(Mono.error(new ChangeSetPersister.NotFoundException()))
                .flatMap(existingSalario -> salarioRepository.updateSalario(salarioDTO.toDomain())
                        .then(Mono.just(existingSalario))
                );
    }

    public Mono<Salario> eliminarSalario(Integer id_salario) {

        return salarioRepository.deleteSalario(id_salario);
    }

    public Flux<Salario> getSalarios() {

        return salarioRepository.findAllSalarios();
    }

}
