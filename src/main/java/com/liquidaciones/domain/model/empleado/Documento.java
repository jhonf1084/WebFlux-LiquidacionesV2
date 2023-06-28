package com.liquidaciones.domain.model.empleado;

import lombok.Builder;

@Builder
public class Documento {

   public Integer value;

    public Documento(Integer value) {
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
