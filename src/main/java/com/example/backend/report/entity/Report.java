package com.example.backend.report.entity;

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
@Table(name = "report")
public class Report {
    @Id
    @Column(name = "report_id", nullable = false)
    private Integer reportId;

    @Column(name = "report_title", length = 255, nullable = false)
    private String reportTitle;

    @Column(name = "created_time", nullable = false)
    private LocalDateTime createdTime;

    @Column(name = "file_path", length = 255, nullable = false)
    private String filePath;

    @Column(name = "report_type", length = 20, nullable = false)
    private String reportType;

    @Column(name = "prompt", columnDefinition = "TEXT")
    private String prompt;

    @Column(name = "data_start_time", nullable = false)
    private LocalDateTime dataStartTime;

    @Column(name = "data_end_time", nullable = false)
    private LocalDateTime dataEndTime;
}