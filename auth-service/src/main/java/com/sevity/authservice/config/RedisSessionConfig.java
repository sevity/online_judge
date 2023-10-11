package com.sevity.authservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;

@Configuration
@EnableRedisHttpSession
public class RedisSessionConfig {
    @Bean
    public StatefulRedisConnection<String, String> redisConnection() {
        RedisClient redisClient = RedisClient.create("redis://localhost:6379");
        return redisClient.connect();
    }    
}