package org.example.grpc.datastoregrpc.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class RedisConfig {
    @Value("${spring.datasource.redis.host}")
    private String host;

    @Value("${spring.datasource.redis.port}")
    private int port;

    @Value("${spring.datasource.redis.url}")
    private String url;

    public String getRedisUrl() {
        return "redis://" + host + ":" + port;
    }
}
