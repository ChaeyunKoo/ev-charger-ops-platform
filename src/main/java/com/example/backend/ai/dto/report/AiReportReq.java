package com.example.backend.ai.dto.report;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AiReportReq {

    private String reportType;
    private String prompt;
    private String dataStartTime;
    private String dataEndTime;
}
