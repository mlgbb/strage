package com.example.strage;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@EnableCaching
@Slf4j
public class StrageApplication {

    public static void main(String[] args) {
        SpringApplication.run(StrageApplication.class, args);
    }

}
