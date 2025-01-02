package org.example.grpc.datastoregrpc.service;

import grpc.common.AnalyticsServerGrpc;
import grpc.common.GRPCData;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.example.grpc.datastoregrpc.model.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
@Slf4j
public class GRPCDataServiceImpl implements GRPCDataService {
    private final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
    private final SummaryService summaryService;

    @GrpcClient(value = "grpc-store-async")
    private AnalyticsServerGrpc.AnalyticsServerStub asyncStub;

    @Value("${fetch.batch-size}")
    private int batchSize;

    @PostConstruct
    public void init() {
        fetchMessages();
    }

    @Override
    public void fetchMessages() {
        executorService.scheduleAtFixedRate(
                () -> asyncStub.askForData(
                        grpc.common.GRPCAnalyticsRequest.newBuilder()
                                .setBatchSize(batchSize)
                                .build(),
                        new StreamObserver<GRPCData>() {
                            @Override
                            public void onNext(GRPCData grpcData) {
                                summaryService.handleData(new Data(grpcData));
                            }

                            @Override
                            public void onError(Throwable throwable) {

                            }

                            @Override
                            public void onCompleted() {
                                log.info("Batch is completed");
                            }
                        }
                ),
                0,
                10,
                TimeUnit.SECONDS
        );
    }
}
