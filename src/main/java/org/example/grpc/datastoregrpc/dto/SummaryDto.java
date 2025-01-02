package org.example.grpc.datastoregrpc.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.example.grpc.datastoregrpc.model.Data;
import org.example.grpc.datastoregrpc.model.SummaryEntry;

import java.util.List;
import java.util.Map;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class SummaryDto {
    private Long sensorId;
    private Map<Data.MeasurementType, List<SummaryEntry>> values;
}
