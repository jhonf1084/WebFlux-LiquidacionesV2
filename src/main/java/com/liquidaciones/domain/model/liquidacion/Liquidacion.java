package com.liquidaciones.domain.model.liquidacion;

import org.springframework.data.annotation.Id;

public class Liquidacion {

    @Id
    private IdLiquidacion id_liquidacion;
    private FkIdEmpleado fk_id_emple;
    private FechaFinalContrato fecha_final_contrato;
    private MotivoRetiro motivo_retiro;
    private TotalDiasLaborado total_dias_laborados;
    private DiasLabAnoActual dias_lab_ano_actual;
    private DiasPendienteVacaciones dias_pendientes_vacaciones;
    private DiasLabUltimoSemestre dias_lab_ultimo_semestre;
    private LiquidacionCesantias liquidacion_cesantias;
    private LiquidacionVacaciones liquidacion_vacaciones;
    private LiquidacionInteresesCesantias liquidacion_intereses_cesantias;
    private LiquidacionPrima liquidacion_prima;
    private NominaPendiente nomina_pendiente;
    private TotalLiquidacion total_liquidacion;

    public Liquidacion(IdLiquidacion id_liquidacion, FkIdEmpleado fk_id_emple, FechaFinalContrato fecha_final_contrato, MotivoRetiro motivo_retiro, TotalDiasLaborado total_dias_laborados, DiasLabAnoActual dias_lab_ano_actual, DiasPendienteVacaciones dias_pendientes_vacaciones, DiasLabUltimoSemestre dias_lab_ultimo_semestre, LiquidacionCesantias liquidacion_cesantias, LiquidacionVacaciones liquidacion_vacaciones, LiquidacionInteresesCesantias liquidacion_intereses_cesantias, LiquidacionPrima liquidacion_prima, NominaPendiente nomina_pendiente, TotalLiquidacion total_liquidacion) {
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

    public IdLiquidacion getId_liquidacion() {
        return id_liquidacion;
    }

    public FkIdEmpleado getFk_id_emple() {
        return fk_id_emple;
    }

    public FechaFinalContrato getFecha_final_contrato() {
        return fecha_final_contrato;
    }

    public MotivoRetiro getMotivo_retiro() {
        return motivo_retiro;
    }

    public TotalDiasLaborado getTotal_dias_laborados() {
        return total_dias_laborados;
    }

    public DiasLabAnoActual getDias_lab_ano_actual() {
        return dias_lab_ano_actual;
    }

    public DiasPendienteVacaciones getDias_pendientes_vacaciones() {
        return dias_pendientes_vacaciones;
    }

    public DiasLabUltimoSemestre getDias_lab_ultimo_semestre() {
        return dias_lab_ultimo_semestre;
    }

    public LiquidacionCesantias getLiquidacion_cesantias() {
        return liquidacion_cesantias;
    }

    public LiquidacionVacaciones getLiquidacion_vacaciones() {
        return liquidacion_vacaciones;
    }

    public LiquidacionInteresesCesantias getLiquidacion_intereses_cesantias() {
        return liquidacion_intereses_cesantias;
    }

    public LiquidacionPrima getLiquidacion_prima() {
        return liquidacion_prima;
    }

    public NominaPendiente getNomina_pendiente() {
        return nomina_pendiente;
    }

    public TotalLiquidacion getTotal_liquidacion() {
        return total_liquidacion;
    }
}
