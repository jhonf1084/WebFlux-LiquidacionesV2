package com.liquidaciones.domain.model.salario;

import lombok.Builder;

@Builder
public class Sueldo {

    private Double value;

    public Sueldo(Double value) {
        this.value = value;
    }

    public Double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Sueldo{" +
                "value=" + value +
                '}';
    }
}
