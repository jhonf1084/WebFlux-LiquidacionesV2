package com.liquidaciones.domain.model.liquidacion;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public class FechaFinalContrato {

    private LocalDate value;

    public FechaFinalContrato(LocalDate value) {
        this.value = value;
    }

    public LocalDate getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "FechaFinalContrato{" +
                "value=" + value +
                '}';
    }
}
