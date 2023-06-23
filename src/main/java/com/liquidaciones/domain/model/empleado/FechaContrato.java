package com.liquidaciones.domain.model.empleado;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public class FechaContrato {

    public LocalDate value;

     public FechaContrato(LocalDate value) {
          this.value = value;
     }

     public LocalDate getValue() {
          return value;
     }

     @Override
     public String toString() {
          return "FechaContrato{" +
                 "value='" + value + '\'' +
                 '}';
     }

}
