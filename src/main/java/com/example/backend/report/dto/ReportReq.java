package com.example.backend.report.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class ReportReq {

    private String reportType;
    private String prompt;
    private LocalDateTime dataStartTime;
    private LocalDateTime dataEndTime;
}
