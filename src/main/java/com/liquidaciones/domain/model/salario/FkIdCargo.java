package com.liquidaciones.domain.model.salario;

import lombok.Builder;

@Builder
public class FkIdCargo {

    private Integer value;

    public FkIdCargo(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "FkIdCargo{" +
                "value=" + value +
                '}';
    }
}
