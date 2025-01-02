package org.example.grpc.datastoregrpc.config;

import org.example.grpc.datastoregrpc.constants.AppConstant;

import java.util.Objects;

public class KeyHelper {
    private final static String DEFAULT_PREFIX = "app";
    private static String PREFIX = null;

    public static void setPrefix(String keyPrefix) {
        PREFIX = keyPrefix;
    }

    public static String getKey(String key) {
      return getPrefix() + AppConstant.DELIMITER + key;
    }

    public static String getPrefix() {
        return Objects.requireNonNullElse(PREFIX, DEFAULT_PREFIX);
    }
}
