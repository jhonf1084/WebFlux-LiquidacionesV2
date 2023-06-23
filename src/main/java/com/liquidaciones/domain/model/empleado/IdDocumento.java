package com.liquidaciones.domain.model.empleado;

import lombok.Builder;

@Builder
public class IdDocumento {

   public Integer value;

    public IdDocumento(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "IdDocumento{" +
                "value='" + value + '\'' +
                '}';
    }
}
