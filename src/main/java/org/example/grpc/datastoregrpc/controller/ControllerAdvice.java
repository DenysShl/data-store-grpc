package org.example.grpc.datastoregrpc.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.grpc.datastoregrpc.exception.SensorNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ControllerAdvice {

    @ExceptionHandler(SensorNotFoundException.class)
    public String handleException(Exception e) {
        String message = new StringBuilder()
                .append("Sensor not found message: ")
                .append(e.getMessage())
                .append(", stacktrace: ")
                .append(e.getStackTrace())
                .toString();

        log.warn(message);
        return message;
    }
}
