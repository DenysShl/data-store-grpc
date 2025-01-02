package org.example.grpc.datastoregrpc.model;

import grpc.common.GRPCData;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class Data {
    private long id;
    private long sensorId;
    private LocalDateTime timestamp;
    private double measurement;
    private MeasurementType measurementType;

    public enum MeasurementType {
        TEMPERATURE, VOLTAGE, POWER
    }

    public Data(GRPCData data) {
        this.id = data.getId();
        this.sensorId = data.getSensorId();
        this.timestamp =
                LocalDateTime.ofInstant(
                        Instant.ofEpochSecond(
                                data.getTimestamp().getSeconds(),
                                data.getTimestamp().getNanos()
                        ),
                        ZoneId.systemDefault()
                );
        this.measurement = data.getMeasurement();
        this.measurementType = MeasurementType.valueOf(data.getMeasurementType().name());
    }
}
