package com.liquidaciones.domain.model.empleado;

import lombok.Builder;

@Builder
public class NombreApellidos {

    public String value;

     public NombreApellidos(String value) {
         this.value = value;
     }

     public String getValue() {
         return value;
     }

     @Override
     public String toString() {
         return "NombreApellidos{" +
                 "value='" + value + '\'' +
                 '}';
     }

}
