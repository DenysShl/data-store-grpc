package org.example.grpc.datastoregrpc.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.grpc.datastoregrpc.model.Data;
import org.example.grpc.datastoregrpc.model.Summary;
import org.example.grpc.datastoregrpc.model.SummaryEntry;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
@RequiredArgsConstructor
@Slf4j
public class SummaryRepositoryImpl implements SummaryRepository {
//    private final

    @Override
    public Optional<Summary> findBySensorId(
            Long sensorId,
            Set<Data.MeasurementType> measurementTypes,
            Set<SummaryEntry.SummaryType> summaryTypes)
    {
        return Optional.empty();
    }

    @Override
    public void handle(Data data) {

    }

    @Override
    public Optional<Summary> findBySensorIdAndMeasurementTypeAndSummaryType(
            Long sensorId,
            Data.MeasurementType measurementType,
            SummaryEntry.SummaryType summaryType)
    {
        return Optional.empty();
    }
}
