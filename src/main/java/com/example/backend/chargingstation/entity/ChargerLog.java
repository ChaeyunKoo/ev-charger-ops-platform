package com.example.backend.chargingstation.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
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
@IdClass(ChargerLogId.class)
@Table(name = "charger_log")
public class ChargerLog {
    @Id
    @ManyToOne
    @Column(name = "chger_id", length = 2, nullable = false)
    private String chgerId;

    @Id
    @Column(name = "stat_id", length = 8, nullable = false)
    private String statId;

    @Id
    @Column(name = "chger_time", nullable = false)
    private LocalDateTime chgerTime;

    @Column(name = "last_tsdt", nullable = false)
    private LocalDateTime lastTsdt;

    @Column(name = "last_tedt", nullable = false)
    private LocalDateTime lastTedt;

    @Column(name = "stat_upd_dt", nullable = false)
    private LocalDateTime statUpdDt;

    @Column(name = "stat", nullable = false)
    private Integer stat;
}