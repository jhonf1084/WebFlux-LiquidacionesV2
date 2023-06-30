package com.liquidaciones.domain.model.liquidacion;

import lombok.Builder;

@Builder
public class LiquidacionVacaciones {

    private Double value;

    public LiquidacionVacaciones(Double value) {
        this.value = value;
    }

    public Double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "LiquidacionVacaciones{" +
                "value=" + value +
                '}';
    }
}
