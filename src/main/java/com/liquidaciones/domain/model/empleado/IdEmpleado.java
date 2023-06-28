package com.liquidaciones.domain.model.empleado;

import lombok.Builder;
import org.springframework.context.annotation.Bean;

@Builder
public class IdEmpleado {

    public Integer value;

    public IdEmpleado(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "IdEmpleado{" +
                "value=" + value +
                '}';
    }
}
