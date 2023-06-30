package com.liquidaciones.domain.model.liquidacion;

import lombok.Builder;

@Builder
public class TotalDiasLaborado {

    private Integer value;

    public TotalDiasLaborado(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "TotalDiasLaborado{" +
                "value=" + value +
                '}';
    }
}
