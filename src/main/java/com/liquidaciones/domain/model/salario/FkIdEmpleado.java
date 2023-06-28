package com.liquidaciones.domain.model.salario;

import lombok.Builder;

@Builder
public class FkIdEmpleado {

    private Integer value;

    public FkIdEmpleado(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "FkIdEmpleado{" +
                "value=" + value +
                '}';
    }
}
