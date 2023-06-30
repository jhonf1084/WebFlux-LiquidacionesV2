package com.liquidaciones.domain.model.liquidacion;

import lombok.Builder;

@Builder
public class TotalLiquidacion {

    private Double value;

    public TotalLiquidacion(Double value) {
        this.value = value;
    }

    public Double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "TotalLiquidacion{" +
                "value=" + value +
                '}';
    }
}
