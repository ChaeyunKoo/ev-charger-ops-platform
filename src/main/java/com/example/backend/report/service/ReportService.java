package com.example.backend.report.service;

import com.example.backend.ai.client.AiReportClient;
import com.example.backend.ai.dto.report.AiReportReq;
import com.example.backend.ai.dto.report.AiReportRes;
import com.example.backend.global.exception.BadRequestException;
import com.example.backend.report.dto.ReportReq;
import com.example.backend.report.dto.ReportRes;
import com.example.backend.report.entity.Report;
import com.example.backend.report.repository.ReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReportService {

    private final ReportRepository reportRepository;
    private final AiReportClient aiReportClient;

    @Transactional
    public ReportRes createReport(ReportReq request) {
        validateRequest(request);

        AiReportReq aiRequest = AiReportReq.builder()
                .reportType(request.getReportType())
                .prompt(request.getPrompt())
                .dataStartTime(request.getDataStartTime().toString())
                .dataEndTime(request.getDataEndTime().toString())
                .build();

        AiReportRes aiResponse = aiReportClient.generateReport(aiRequest);

        Report report = Report.builder()
                .reportTitle(aiResponse.getReportTitle())
                .createdTime(LocalDateTime.now())
                .filePath(aiResponse.getFilePath())
                .reportType(request.getReportType())
                .prompt(request.getPrompt())
                .dataStartTime(request.getDataStartTime())
                .dataEndTime(request.getDataEndTime())
                .build();

        Report savedReport = reportRepository.save(report);

        return ReportRes.from(savedReport);
    }

    private void validateRequest(ReportReq request) {
        if (request.getReportType() == null || request.getReportType().isBlank()) {
            throw new BadRequestException("보고서 유형을 입력하지 않았습니다");
        }
        if (request.getDataStartTime() == null) {
            throw new BadRequestException("데이터 시작 시간을 입력하지 않았습니다");
        }
        if (request.getDataEndTime() == null) {
            throw new BadRequestException("데이터 종료 시간을 입력하지 않았습니다");
        }
    }
}
