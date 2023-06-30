package com.liquidaciones.domain.model.salario;

import lombok.Builder;

@Builder
public class AuxilioTransporte {

    private Double value;

    public AuxilioTransporte(Double value) {
        this.value = value;
    }

    public Double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "AuxilioTransporte{" +
                "value=" + value +
                '}';
    }
}
