package org.example.grpc.datastoregrpc.service;

import org.example.grpc.datastoregrpc.model.Data;
import org.example.grpc.datastoregrpc.model.Summary;
import org.example.grpc.datastoregrpc.model.SummaryEntry;

import java.util.Set;

public interface SummaryService {
    Summary getSummary(Long sensorId, Set<Data.MeasurementType> measurementTypes, Set<SummaryEntry.SummaryType> summaryTypes);

    void handleData(Data data);
}
