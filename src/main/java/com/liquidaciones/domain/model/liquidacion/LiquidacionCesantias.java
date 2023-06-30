package com.liquidaciones.domain.model.liquidacion;

import lombok.Builder;

@Builder
public class LiquidacionCesantias {

    private Double value;

    public LiquidacionCesantias(Double value) {
        this.value = value;
    }

    public Double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "LiquidacionCesantias{" +
                "value=" + value +
                '}';
    }
}
