package org.example.grpc.datastoregrpc.config;

import org.example.grpc.datastoregrpc.constants.AppConstant;
import org.example.grpc.datastoregrpc.model.Data;

import static org.example.grpc.datastoregrpc.constants.AppConstant.DELIMITER;
import static org.example.grpc.datastoregrpc.constants.AppConstant.SENSORS;

public class RedisSchema {

    public static  String sensorKeys() {
        return KeyHelper.getKey(SENSORS);
    }

    public String summaryKey(
            Long sensorId,
            Data.MeasurementType measurementType) {
        return KeyHelper.getKey(SENSORS + DELIMITER + sensorId + DELIMITER + measurementType);
    }
}
