package com.liquidaciones.domain.model.liquidacion;

import lombok.Builder;

@Builder
public class DiasLabAnoActual {

    private Integer value;

    public DiasLabAnoActual(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "DiasLabAnoActual{" +
                "value=" + value +
                '}';
    }
}
