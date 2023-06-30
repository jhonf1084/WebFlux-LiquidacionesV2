package com.liquidaciones.domain.model.liquidacion;

import lombok.Builder;

@Builder
public class LiquidacionPrima {
    private Double value;

    public LiquidacionPrima(Double value) {
        this.value = value;
    }

    public Double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "LiquidacionPrima{" +
                "value=" + value +
                '}';
    }
}


