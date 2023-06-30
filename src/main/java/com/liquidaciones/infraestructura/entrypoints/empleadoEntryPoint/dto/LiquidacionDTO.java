package com.liquidaciones.infraestructura.entrypoints.empleadoEntryPoint.dto;

import com.liquidaciones.domain.model.liquidacion.IdLiquidacion;
import com.liquidaciones.domain.model.liquidacion.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

public class LiquidacionDTO {

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

    public Liquidacion toDomain(){
        return new Liquidacion(
                IdLiquidacion.builder().value(id_liquidacion).build(),
                FkIdEmpleado.builder().value(fk_id_emple).build(),
                FechaFinalContrato.builder().value(fecha_final_contrato).build(),
                MotivoRetiro.builder().value(motivo_retiro).build(),
                TotalDiasLaborado.builder().value(total_dias_laborados).build(),
                DiasLabAnoActual.builder().value(dias_lab_ano_actual).build(),
                DiasPendienteVacaciones.builder().value(dias_pendientes_vacaciones).build(),
                DiasLabUltimoSemestre.builder().value(dias_lab_ultimo_semestre).build(),
                LiquidacionCesantias.builder().value(liquidacion_cesantias).build(),
                LiquidacionVacaciones.builder().value(liquidacion_vacaciones).build(),
                LiquidacionInteresesCesantias.builder().value(liquidacion_intereses_cesantias).build(),
                LiquidacionPrima.builder().value(liquidacion_prima).build(),
                NominaPendiente.builder().value(nomina_pendiente).build(),
                TotalLiquidacion.builder().value(total_liquidacion).build());
    }

    public static LiquidacionDTO fromDomain(Liquidacion liquidacion){
        return new LiquidacionDTO(
                liquidacion.getId_liquidacion().getValue(),
                liquidacion.getFk_id_emple().getValue(),
                liquidacion.getFecha_final_contrato().getValue(),
                liquidacion.getMotivo_retiro().getValue(),
                liquidacion.getTotal_dias_laborados().getValue(),
                liquidacion.getDias_lab_ano_actual().getValue(),
                liquidacion.getDias_pendientes_vacaciones().getValue(),
                liquidacion.getDias_lab_ultimo_semestre().getValue(),
                liquidacion.getLiquidacion_cesantias().getValue(),
                liquidacion.getLiquidacion_vacaciones().getValue(),
                liquidacion.getLiquidacion_intereses_cesantias().getValue(),
                liquidacion.getLiquidacion_prima().getValue(),
                liquidacion.getNomina_pendiente().getValue(),
                liquidacion.getTotal_liquidacion().getValue());

    }

    public LiquidacionDTO(Integer id_liquidacion, Integer fk_id_emple, LocalDate fecha_final_contrato, String motivo_retiro, Integer total_dias_laborados, Integer dias_lab_ano_actual, Integer dias_pendientes_vacaciones, Integer dias_lab_ultimo_semestre, Double liquidacion_cesantias, Double liquidacion_vacaciones, Double liquidacion_intereses_cesantias, Double liquidacion_prima, Double nomina_pendiente, Double total_liquidacion) {
        this.id_liquidacion = id_liquidacion;
        this.fk_id_emple = fk_id_emple;
        this.fecha_final_contrato = fecha_final_contrato;
        this.motivo_retiro = motivo_retiro;
        this.total_dias_laborados = total_dias_laborados;
        this.dias_lab_ano_actual = dias_lab_ano_actual;
        this.dias_pendientes_vacaciones = dias_pendientes_vacaciones;
        this.dias_lab_ultimo_semestre = dias_lab_ultimo_semestre;
        this.liquidacion_cesantias = liquidacion_cesantias;
        this.liquidacion_vacaciones = liquidacion_vacaciones;
        this.liquidacion_intereses_cesantias = liquidacion_intereses_cesantias;
        this.liquidacion_prima = liquidacion_prima;
        this.nomina_pendiente = nomina_pendiente;
        this.total_liquidacion = total_liquidacion;
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
