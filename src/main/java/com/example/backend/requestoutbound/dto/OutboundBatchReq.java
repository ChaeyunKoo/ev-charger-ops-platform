package com.example.backend.requestoutbound.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class OutboundBatchReq {

    private List<Long> reqIds;
}
