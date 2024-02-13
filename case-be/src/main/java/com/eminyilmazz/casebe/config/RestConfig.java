package com.eminyilmazz.casebe.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class RestConfig {
    private static final Logger logger = LoggerFactory.getLogger(RestConfig.class);

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
    logger.info("RestTemplate is configured.");
        return builder
                .setConnectTimeout(Duration.ofMillis(10000L))
                .setReadTimeout(Duration.ofMillis(15000L))
                .build();
    }
}
