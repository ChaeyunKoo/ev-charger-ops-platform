package com.example.backend.requestoutbound.controller;

import com.example.backend.requestoutbound.dto.OutboundBatchReq;
import com.example.backend.requestoutbound.dto.OutboundBatchRes;
import com.example.backend.requestoutbound.service.RequestOutboundService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "RequestOutbound", description = "민원 처리 API")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class RequestOutboundController {

    private final RequestOutboundService requestOutboundService;

    @Operation(summary = "민원 일괄 처리", description = "선택된 민원들에 대해 AI 답변을 생성하여 처리")
    @PostMapping("/request_outbound")
    public ResponseEntity<OutboundBatchRes> processRequests(@RequestBody OutboundBatchReq request) {
        OutboundBatchRes response = requestOutboundService.processRequests(request);
        return ResponseEntity.ok(response);
    }
}
