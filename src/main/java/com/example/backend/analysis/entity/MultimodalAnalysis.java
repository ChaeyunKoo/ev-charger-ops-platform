package com.example.backend.analysis.entity;

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
@Table(name = "multimodal_analysis")
public class MultimodalAnalysis {
    @Id
    @Column(name = "multimodal_id", nullable = false)
    private Integer multimodalId;

    @Column(name = "fire_yn", nullable = false)
    private Boolean fireYn;

    @Column(name = "fire_details", length = 200, nullable = false)
    private String fireDetails;

    @Column(name = "broke_yn", nullable = false)
    private Boolean brokeYn;

    @Column(name = "broke_details", length = 200, nullable = false)
    private String brokeDetails;

    @Column(name = "clean_yn", nullable = false)
    private Boolean cleanYn;

    @Column(name = "clean_details", length = 200, nullable = false)
    private String cleanDetails;

    @Column(name = "imgsensoranal_time", nullable = false)
    private LocalDateTime imgsensoranalTime;

    @Column(name = "img_id", nullable = false)
    private Integer imgId;

    @Column(name = "img_time", nullable = false)
    private LocalDateTime imgTime;

    @Column(name = "sensor_time", nullable = false)
    private LocalDateTime sensorTime;
}