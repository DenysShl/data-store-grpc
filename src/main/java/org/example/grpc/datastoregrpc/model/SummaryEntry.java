package org.example.grpc.datastoregrpc.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class SummaryEntry {
    private SummaryType summaryType;
    private double value;
    private long counter;

    public  enum SummaryType {
        AVG,
        MAX,
        MIN,
        SUM
    }
}
