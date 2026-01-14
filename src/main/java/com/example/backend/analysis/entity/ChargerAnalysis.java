package com.example.backend.analysis.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
@Table(name = "charger_analysis")
public class ChargerAnalysis {
    @Id
    @Column(name = "chgeranal_id", nullable = false)
    private Integer chgeranalId;

    @Column(name = "unconf_min")
    private Integer unconfMin;
}