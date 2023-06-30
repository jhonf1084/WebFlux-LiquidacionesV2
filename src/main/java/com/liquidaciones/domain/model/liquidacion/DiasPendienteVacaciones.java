package com.liquidaciones.domain.model.liquidacion;

import lombok.Builder;

@Builder
public class DiasPendienteVacaciones {

    private Integer value;

    public DiasPendienteVacaciones(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "DiasPendienteVacaciones{" +
                "value=" + value +
                '}';
    }
}
