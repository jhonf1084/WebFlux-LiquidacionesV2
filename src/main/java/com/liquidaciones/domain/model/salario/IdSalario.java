package com.liquidaciones.domain.model.salario;

import lombok.Builder;

@Builder
public class IdSalario {

    private Integer value;

    public IdSalario(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "IdSalario{" +
                "value=" + value +
                '}';
    }
}
