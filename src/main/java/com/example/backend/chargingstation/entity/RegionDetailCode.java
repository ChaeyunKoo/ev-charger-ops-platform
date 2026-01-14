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
@Table(name = "region_detail_code")
public class RegionDetailCode {
    @Id
    @Column(name = "zscode", length = 5, nullable = false)
    private String zscode;

    @Column(name = "zscode_description", length = 5, nullable = false)
    private String zscodeDescription;
}