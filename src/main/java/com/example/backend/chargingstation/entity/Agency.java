package com.example.backend.chargingstation.entity;

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
@Table(name = "agency_id")
public class Agency {
    @Id
    @Column(name = "busiId", length = 2, nullable = false)
    private String busiId;

    @Column(name = "busid_description", length = 20, nullable = false)
    private String busidDescription;
}