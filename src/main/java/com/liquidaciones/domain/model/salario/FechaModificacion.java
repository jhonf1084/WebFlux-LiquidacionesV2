package com.liquidaciones.domain.model.salario;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public class FechaModificacion {

    private LocalDate value;

    public FechaModificacion(LocalDate value) {
        this.value = value;
    }

    public LocalDate getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "FechaModificacion{" +
                "value=" + value +
                '}';
    }
}
