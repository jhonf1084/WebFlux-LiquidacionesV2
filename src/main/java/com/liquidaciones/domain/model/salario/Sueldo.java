package com.liquidaciones.domain.model.salario;

import lombok.Builder;

@Builder
public class Sueldo {

    private Float value;

    public Sueldo(Float value) {
        this.value = value;
    }

    public Float getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Sueldo{" +
                "value=" + value +
                '}';
    }
}
