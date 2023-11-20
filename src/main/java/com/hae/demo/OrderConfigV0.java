package com.hae.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.micrometer.core.instrument.MeterRegistry;

@Configuration
public class OrderConfigV0 {

    @Bean
    OrderService orderService(final MeterRegistry meterRegistry) {
        return new OrderServiceV0(meterRegistry);
    }
}