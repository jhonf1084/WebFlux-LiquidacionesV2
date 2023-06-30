package com.liquidaciones.domain.model.liquidacion;

import lombok.Builder;

@Builder
public class MotivoRetiro {

    private String value;

    public MotivoRetiro(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "MotivoRetiro{" +
                "value='" + value + '\'' +
                '}';
    }
}
