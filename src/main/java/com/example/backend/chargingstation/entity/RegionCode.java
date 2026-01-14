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
@Table(name = "region_code")
public class RegionCode {
    @Id
    @Column(name = "zcode", length = 2, nullable = false)
    private String zcode;

    @Column(name = "zcode_description", length = 8, nullable = false)
    private String zcodeDescription;
}