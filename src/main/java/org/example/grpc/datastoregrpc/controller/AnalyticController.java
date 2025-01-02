package org.example.grpc.datastoregrpc.controller;

import lombok.RequiredArgsConstructor;
import org.example.grpc.datastoregrpc.dto.SummaryDto;
import org.example.grpc.datastoregrpc.mapper.SummaryMapper;
import org.example.grpc.datastoregrpc.model.Data;
import org.example.grpc.datastoregrpc.model.Summary;
import org.example.grpc.datastoregrpc.model.SummaryEntry;
import org.example.grpc.datastoregrpc.service.SummaryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/v1/analytic")
@RequiredArgsConstructor
public class AnalyticController {
    private final SummaryMapper summaryMapper;
    private final SummaryService summaryService;

    @GetMapping("/summary/{sensorId}")
    public SummaryDto getSummary(@PathVariable Long sensorId,
                                 @RequestParam(value = "mt", required = false) Set<Data.MeasurementType> measurementTypes,
                                 @RequestParam(value = "st", required = false) Set<SummaryEntry.SummaryType> summaryTypes) {
        Summary summary = summaryService.getSummary(sensorId, measurementTypes, summaryTypes);
        return summaryMapper.toDto(summary);
    }
}
