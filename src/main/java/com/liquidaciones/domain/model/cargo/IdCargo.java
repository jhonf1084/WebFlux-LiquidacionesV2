package com.liquidaciones.domain.model.cargo;

import lombok.Builder;

@Builder
public class IdCargo {

    public Integer value;

    public IdCargo(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "IdCargo{" +
                "value=" + value +
                '}';
    }
}
