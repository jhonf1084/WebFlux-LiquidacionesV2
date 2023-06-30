package com.liquidaciones.domain.model.liquidacion;

import lombok.Builder;

@Builder
public class NominaPendiente {

    private Double value;

    public NominaPendiente(Double value) {
        this.value = value;
    }

    public Double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "NominaPendiente{" +
                "value=" + value +
                '}';
    }
}
