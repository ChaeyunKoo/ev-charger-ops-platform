package com.example.backend.chargingstation.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@IdClass(ChargerId.class)
@Table(name = "charger")
public class Charger {
    @Id
    @ManyToOne
    @JoinColumn(name = "stat_id")
    private ChargingStation chargingstation;

    @Id
    @Column(name = "chger_id", length = 2, nullable = false)
    private String chgerId;

    @Column(name = "chger_type", length = 2, nullable = false)
    private String chgerType;

    @Column(name = "output", length = 8, nullable = false)
    private String output;

    @Column(name = "method", length = 8, nullable = false)
    private String method;
}