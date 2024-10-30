package com.codeq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootConsumerApplication {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        SpringApplication.run(SpringBootConsumerApplication.class);
    }
}