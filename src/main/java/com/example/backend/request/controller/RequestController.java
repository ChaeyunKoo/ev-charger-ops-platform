package com.example.backend.request.controller;

import com.example.backend.request.dto.RequestDetailReq;
import com.example.backend.request.dto.RequestDetailRes;
import com.example.backend.request.dto.RequestListItemRes;
import com.example.backend.request.service.RequestService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Request", description = "민원 API")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class RequestController {

    private final RequestService requestService;

    @Operation(summary = "민원 리스트 조회", description = "전체 민원 목록 조회")
    @GetMapping("/request")
    public ResponseEntity<List<RequestListItemRes>> getRequestList() {
        List<RequestListItemRes> response = requestService.getRequestList();
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "민원 상세 조회", description = "민원 ID로 상세 정보 및 답변 조회")
    @PostMapping("/request")
    public ResponseEntity<RequestDetailRes> getRequestDetail(@RequestBody RequestDetailReq request) {
        RequestDetailRes response = requestService.getRequestDetail(request);
        return ResponseEntity.ok(response);
    }
}
