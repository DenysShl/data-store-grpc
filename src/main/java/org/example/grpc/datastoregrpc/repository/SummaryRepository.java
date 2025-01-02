package org.example.grpc.datastoregrpc.repository;

import org.example.grpc.datastoregrpc.model.Data;
import org.example.grpc.datastoregrpc.model.Summary;
import org.example.grpc.datastoregrpc.model.SummaryEntry;
import org.springframework.data.repository.Repository;

import java.util.Optional;
import java.util.Set;

public interface SummaryRepository extends Repository<Summary, Long> {

    Optional<Summary> findBySensorId(
            Long sensorId,
            Set<Data.MeasurementType> measurementTypes,
            Set<SummaryEntry.SummaryType> summaryTypes
    );

    void handle(Data data);

    Optional<Summary> findBySensorIdAndMeasurementTypeAndSummaryType(
            Long sensorId,
            Data.MeasurementType measurementType,
            SummaryEntry.SummaryType summaryType);
}
