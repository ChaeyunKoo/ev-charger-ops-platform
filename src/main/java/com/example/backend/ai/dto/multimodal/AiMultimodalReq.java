package com.example.backend.ai.dto.multimodal;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AiMultimodalReq {

    private ImageInfo image;
    private SensorLogInfo sensorLog;

    @Getter
    @Builder
    public static class ImageInfo {
        private String imgPath;
    }

    @Getter
    @Builder
    public static class SensorLogInfo {
        private String sensorTime;
        private String statUpdDt;
        private String note;
        private String acInputVoltageV;
        private String acFrequencyHz;
        private String currentA;
        private String powerKw;
        private String energyKwh;
        private String acLeakageMa;
        private String groundOk;
        private String cabinetTempC;
        private String ambientTempC;
        private String humidityPct;
        private String connectorT;
        private String ambientT;
        private String batteryT;
    }
}
