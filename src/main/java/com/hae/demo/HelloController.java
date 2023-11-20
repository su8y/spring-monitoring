package com.hae.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloController
 */
@RestController
public class HelloController {

    @GetMapping("hello")
    public String hello() {
        System.out.println("HelloController.hello()");
        return "HELLO";
    }
}