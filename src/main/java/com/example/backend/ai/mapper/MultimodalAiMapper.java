package com.example.backend.ai.mapper;

import com.example.backend.ai.dto.multimodal.AiMultimodalReq;
import com.example.backend.chargingstation.entity.ImageLog;
import com.example.backend.chargingstation.entity.SensorLog;
import org.springframework.stereotype.Component;

@Component
public class MultimodalAiMapper {

    public AiMultimodalReq.ImageInfo toImageInfo(ImageLog imageLog) {
        if (imageLog == null) {
            return null;
        }
        return AiMultimodalReq.ImageInfo.builder()
                .imgPath(imageLog.getImgPath())
                .build();
    }

    public AiMultimodalReq.SensorLogInfo toSensorLogInfo(SensorLog sensorLog) {
        if (sensorLog == null) {
            return null;
        }
        return AiMultimodalReq.SensorLogInfo.builder()
                .sensorTime(sensorLog.getSensorTime())
                .statUpdDt(sensorLog.getStatUpdDt())
                .note(sensorLog.getNote())
                .acInputVoltageV(sensorLog.getAcInputVoltageV())
                .acFrequencyHz(sensorLog.getAcFrequencyHz())
                .currentA(sensorLog.getCurrentA())
                .powerKw(sensorLog.getPowerKw())
                .energyKwh(sensorLog.getEnergyKwh())
                .acLeakageMa(sensorLog.getAcLeakageMa())
                .groundOk(sensorLog.getGroundOk())
                .cabinetTempC(sensorLog.getCabinetTempC())
                .ambientTempC(sensorLog.getAmbientTempC())
                .humidityPct(sensorLog.getHumidityPct())
                .connectorT(sensorLog.getConnectorT())
                .ambientT(sensorLog.getAmbientT())
                .batteryT(sensorLog.getBatteryT())
                .build();
    }
}
