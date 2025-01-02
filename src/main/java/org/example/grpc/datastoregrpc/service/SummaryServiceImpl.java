package org.example.grpc.datastoregrpc.service;

import lombok.RequiredArgsConstructor;
import org.example.grpc.datastoregrpc.exception.SensorNotFoundException;
import org.example.grpc.datastoregrpc.mapper.SummaryMapper;
import org.example.grpc.datastoregrpc.model.Data;
import org.example.grpc.datastoregrpc.model.Summary;
import org.example.grpc.datastoregrpc.model.SummaryEntry;
import org.example.grpc.datastoregrpc.repository.SummaryRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class SummaryServiceImpl implements SummaryService {
    private final SummaryRepository summaryRepository;

    @Override
    public Summary getSummary(Long sensorId, Set<Data.MeasurementType> measurementTypes, Set<SummaryEntry.SummaryType> summaryTypes) {
        return summaryRepository.findBySensorId(
                sensorId,
                measurementTypes == null ? Set.of(Data.MeasurementType.values()) : measurementTypes,
                summaryTypes == null ? Set.of(SummaryEntry.SummaryType.values()) : summaryTypes
        )
                .orElseThrow(SensorNotFoundException::new);
    }

    @Override
    public void handleData(Data data) {
        summaryRepository.handle(data);
    }
}
