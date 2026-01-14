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
@Table(name = "charging_station")
public class ChargingStation {
    @Id
    @Column(name = "stat_id", length = 8, nullable = false)
    private String statId;

    @Column(name = "stat_nm", length = 100, nullable = false)
    private String statNm;

    @Column(name = "addr", length = 150, nullable = false)
    private String addr;

    @Column(name = "lat", nullable = false)
    private Double lat;

    @Column(name = "lng", nullable = false)
    private Double lng;

    @Column(name = "busi_call", length = 20, nullable = false)
    private String busiCall;

    @Column(name = "note", length = 200, nullable = false)
    private String note;

    @Column(name = "year", nullable = false)
    private Integer year;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "zscode")
    private RegionDetailCode regiondetailcode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "zcode")
    private RegionCode regioncode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "busiId")
    private Agency agency
}