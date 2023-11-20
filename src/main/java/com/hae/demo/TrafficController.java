package com.hae.demo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class TrafficController {
    private List<String> list = new ArrayList<>();
    @Autowired
    private DataSource dataSource;

    @GetMapping("/cpu")
    public String cpu() {
        log.info("CPU");
        long value = 0;
        for (long i = 0; i < 100000000L; i++) {
            value++;
        }
        return "ok value" + value;

    }

    @GetMapping("/jvm")
    public String jvm() {
        log.info("JVM size ={}", list.size());
        for (int i = 0; i < 1000000; i++) {
            list.add("hello jvm!" + i);
        }
        return "OK";
    }

    @GetMapping("jdbc")
    public String jdbc() throws SQLException {
        log.info("jdbc");
        Connection conn = dataSource.getConnection();
        log.info("connection info={}", conn);
        return "OK";
    }

}
