package com.liquidaciones.domain.model.salario;

import lombok.Builder;

@Builder
public class AuxilioTransporte {

    private Float value;

    public AuxilioTransporte(Float value) {
        this.value = value;
    }

    public Float getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "AuxilioTransporte{" +
                "value=" + value +
                '}';
    }
}
