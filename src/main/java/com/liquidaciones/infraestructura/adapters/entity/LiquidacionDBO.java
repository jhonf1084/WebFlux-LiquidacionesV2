package com.liquidaciones.infraestructura.adapters.entity;

import com.liquidaciones.domain.model.liquidacion.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Table(name = "liquidaciones")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LiquidacionDBO {

    @Id
    private Integer id_liquidacion;
    private Integer fk_id_emple;
    private LocalDate fecha_final_contrato;
    private String motivo_retiro;
    private Integer total_dias_laborados;
    private Integer dias_lab_ano_actual;
    private Integer dias_pendientes_vacaciones;
    private Integer dias_lab_ultimo_semestre;
    private Double liquidacion_cesantias;
    private Double liquidacion_vacaciones;
    private Double liquidacion_intereses_cesantias;
    private Double liquidacion_prima;
    private Double nomina_pendiente;
    private Double total_liquidacion;

    public static LiquidacionDBO fromDomain(Liquidacion liquidacion) {
        return LiquidacionDBO.builder()
                .id_liquidacion(liquidacion.getId_liquidacion().getValue())
                .fk_id_emple(liquidacion.getFk_id_emple().getValue())
                .fecha_final_contrato(liquidacion.getFecha_final_contrato().getValue())
                .motivo_retiro(liquidacion.getMotivo_retiro().getValue())
                .total_dias_laborados(liquidacion.getTotal_dias_laborados().getValue())
                .dias_lab_ano_actual(liquidacion.getDias_lab_ano_actual().getValue())
                .dias_pendientes_vacaciones(liquidacion.getDias_pendientes_vacaciones().getValue())
                .dias_lab_ultimo_semestre(liquidacion.getDias_lab_ultimo_semestre().getValue())
                .liquidacion_cesantias(liquidacion.getLiquidacion_cesantias().getValue())
                .liquidacion_vacaciones(liquidacion.getLiquidacion_vacaciones().getValue())
                .liquidacion_intereses_cesantias(liquidacion.getLiquidacion_intereses_cesantias().getValue())
                .liquidacion_prima(liquidacion.getLiquidacion_prima().getValue())
                .nomina_pendiente(liquidacion.getNomina_pendiente().getValue())
                .total_liquidacion(liquidacion.getTotal_liquidacion().getValue())
                .build();
    }

    public static Liquidacion toDomain(LiquidacionDBO liquidacionDBO) {
        return new Liquidacion(
                IdLiquidacion.builder().value(liquidacionDBO.id_liquidacion).build(),
                FkIdEmpleado.builder().value(liquidacionDBO.fk_id_emple).build(),
                FechaFinalContrato.builder().value(liquidacionDBO.fecha_final_contrato).build(),
                MotivoRetiro.builder().value(liquidacionDBO.motivo_retiro).build(),
                TotalDiasLaborado.builder().value(liquidacionDBO.total_dias_laborados).build(),
                DiasLabAnoActual.builder().value(liquidacionDBO.dias_lab_ano_actual).build(),
                DiasPendienteVacaciones.builder().value(liquidacionDBO.dias_pendientes_vacaciones).build(),
                DiasLabUltimoSemestre.builder().value(liquidacionDBO.dias_lab_ultimo_semestre).build(),
                LiquidacionCesantias.builder().value(liquidacionDBO.liquidacion_cesantias).build(),
                LiquidacionVacaciones.builder().value(liquidacionDBO.liquidacion_vacaciones).build(),
                LiquidacionInteresesCesantias.builder().value(liquidacionDBO.liquidacion_intereses_cesantias).build(),
                LiquidacionPrima.builder().value(liquidacionDBO.liquidacion_prima).build(),
                NominaPendiente.builder().value(liquidacionDBO.nomina_pendiente).build(),
                TotalLiquidacion.builder().value(liquidacionDBO.total_liquidacion).build());
    }

    public Integer getId_liquidacion() {
        return id_liquidacion;
    }

    public Integer getFk_id_emple() {
        return fk_id_emple;
    }

    public LocalDate getFecha_final_contrato() {
        return fecha_final_contrato;
    }

    public String getMotivo_retiro() {
        return motivo_retiro;
    }

    public Integer getTotal_dias_laborados() {
        return total_dias_laborados;
    }

    public Integer getDias_lab_ano_actual() {
        return dias_lab_ano_actual;
    }

    public Integer getDias_pendientes_vacaciones() {
        return dias_pendientes_vacaciones;
    }

    public Integer getDias_lab_ultimo_semestre() {
        return dias_lab_ultimo_semestre;
    }

    public Double getLiquidacion_cesantias() {
        return liquidacion_cesantias;
    }

    public Double getLiquidacion_vacaciones() {
        return liquidacion_vacaciones;
    }

    public Double getLiquidacion_intereses_cesantias() {
        return liquidacion_intereses_cesantias;
    }

    public Double getLiquidacion_prima() {
        return liquidacion_prima;
    }

    public Double getNomina_pendiente() {
        return nomina_pendiente;
    }

    public Double getTotal_liquidacion() {
        return total_liquidacion;
    }
}
