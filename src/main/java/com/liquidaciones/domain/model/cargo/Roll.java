package com.liquidaciones.domain.model.cargo;

import lombok.Builder;

@Builder
public class Roll {

    private String value;

    public Roll(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Roll{" +
                "value='" + value + '\'' +
                '}';
    }
}
