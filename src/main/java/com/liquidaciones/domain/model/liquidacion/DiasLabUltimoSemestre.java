package com.liquidaciones.domain.model.liquidacion;

import lombok.Builder;

@Builder
public class DiasLabUltimoSemestre {

    private Integer value;

    public DiasLabUltimoSemestre(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "DiasLabUltimoSemestre{" +
                "value=" + value +
                '}';
    }
}
