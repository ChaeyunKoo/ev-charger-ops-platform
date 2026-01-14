package com.example.backend.monitoring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sensor_log")
public class SensorLog {
    @Id
    @Column(name = "sensor_time", nullable = false)
    private LocalDateTime sensorTime;

    @Id
    @ManyToOne
    @Column(name = "chger_id")
    private Charger charger;

    @Id
    @ManyToOne
    @Column(name = "stat_id")
    private Charger charger;

    @Column(name = "stat_upd_dt", length = 14, nullable = false)
    private String statUpdDt;

    @Column(name = "note", length = 200, nullable = false)
    private String note;

    @Column(name = "ac_input_voltage_v")
    private Double acInputVoltageV;

    @Column(name = "ac_frequency_hz")
    private Double acFrequencyHz;

    @Column(name = "current_a")
    private Double currentA;

    @Column(name = "power_kw")
    private Double powerKw;

    @Column(name = "energy_kwh")
    private Double energyKwh;

    @Column(name = "ac_leakage_ma")
    private Double acLeakageMa;

    @Column(name = "ground_ok")
    private Boolean groundOk;

    @Column(name = "cabinet_temp_c")
    private Double cabinetTempC;

    @Column(name = "ambient_temp_c")
    private Double ambientTempC;

    @Column(name = "humidity_pct")
    private Double humidityPct;

    @Column(name = "connector_t")
    private Double connectorT;

    @Column(name = "ambient_t")
    private Double ambientT;

    @Column(name = "battery_t")
    private Double batteryT;
}