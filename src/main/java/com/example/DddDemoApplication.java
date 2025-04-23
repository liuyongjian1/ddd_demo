package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.infrastructure.mapper")
public class DddDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DddDemoApplication.class, args);
    }
} 