package com.liquidaciones.domain.model.liquidacion;

import lombok.Builder;

@Builder
public class IdLiquidacion {

    private Integer value;

    public IdLiquidacion(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "IdLiquidacion{" +
                "value=" + value +
                '}';
    }
}
