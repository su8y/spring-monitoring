package com.hae.demo;

import java.util.concurrent.atomic.AtomicInteger;

import io.micrometer.core.instrument.Timer;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrderServiceV0 implements OrderService{

    private AtomicInteger stock = new AtomicInteger(100);
    private final MeterRegistry meterRegistry;

    public OrderServiceV0(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    @Override
    public void order() {

        Timer register = Timer.builder("my.order")
            .tag("class",this.getClass().getName())
            .tag("method","order")
            .description("order")
            .register(meterRegistry);
        register.record(()->{
            log.info("주문");
            stock.decrementAndGet();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
            // .increment();;
        
    }

    @Override
    public void cancel() {
        log.info("취소");
        stock.incrementAndGet();

        Timer.builder("my.order")
            .tag("class",this.getClass().getName())
            .tag("method","cancel")
            .description("order")
            .register(meterRegistry);
            // .increment();;
    }

    @Override
    public AtomicInteger getStock() {
        return stock;
    }
    
}
