package com.hae.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.binder.MeterBinder;
import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class StockConfigV2 {
    @Bean
    MeterBinder stockSize(OrderService orderService) {
        return registry -> Gauge.builder("my.stock", orderService, service -> {
            log.info("stock gauge call");
            return service.getStock().get();
        }).register(registry);
    }
}
