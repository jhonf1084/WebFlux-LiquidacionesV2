package com.liquidaciones.domain.model.liquidacion;

import lombok.Builder;

@Builder
public class LiquidacionInteresesCesantias {

    private Double value;

    public LiquidacionInteresesCesantias(Double value) {
        this.value = value;
    }

    public Double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "LiquidacionInteresesCesantias{" +
                "value=" + value +
                '}';
    }
}

