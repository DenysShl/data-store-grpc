package org.example.grpc.datastoregrpc.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@ToString
public class Summary {
    private Long sensorId;
    private Map<Data.MeasurementType, List<SummaryEntry>> values;

    public Summary() {
        this.values = new HashMap<>();
    }

    public void addValue(Data.MeasurementType type, SummaryEntry entry) {
        if (values.containsKey(type)) {
            List<SummaryEntry> summaryEntries = new ArrayList<>(values.get(type));
            summaryEntries.add(entry);
            values.put(type, summaryEntries);
        } else {
            values.put(type, List.of(entry));
        }
    }
}
