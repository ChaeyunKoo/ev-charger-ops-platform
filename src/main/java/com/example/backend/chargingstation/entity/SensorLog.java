package com.example.backend.chargingstation.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "sensor_log")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SensorLog {

    @Id
    @Column(name = "sensor_time")
    private LocalDateTime sensorTime;

    @Column(name = "chger_id", nullable = false, length = 2)
    private String chgerId;

    @Column(name = "stat_id", nullable = false, length = 8)
    private String statId;

    @Column(name = "zcode", nullable = false, length = 2)
    private String zcode;

    @Column(name = "zscode", nullable = false, length = 5)
    private String zscode;

    @Column(name = "busi_id", nullable = false, length = 2)
    private String busiId;

    @Column(name = "stat_upd_dt", nullable = false, length = 14)
    private String statUpdDt;

    @Column(name = "note", nullable = false, length = 200)
    private String note;

    @Column(name = "ac_input_voltage_v")
    private String acInputVoltageV;

    @Column(name = "ac_frequency_hz")
    private String acFrequencyHz;

    @Column(name = "current_a")
    private String currentA;

    @Column(name = "power_kw")
    private String powerKw;

    @Column(name = "energy_kwh")
    private String energyKwh;

    @Column(name = "ac_leakage_ma")
    private String acLeakageMa;

    @Column(name = "ground_ok")
    private String groundOk;

    @Column(name = "cabinet_temp_c")
    private String cabinetTempC;

    @Column(name = "ambient_temp_c")
    private String ambientTempC;

    @Column(name = "humidity_pct")
    private String humidityPct;

    @Column(name = "connector_t")
    private String connectorT;

    @Column(name = "ambient_t")
    private String ambientT;

    @Column(name = "battery_t")
    private String batteryT;
}
