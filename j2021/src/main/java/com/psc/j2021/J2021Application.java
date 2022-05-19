package com.psc.j2021;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@Slf4j
@SpringBootApplication
public class J2021Application {

    @Value("${spring.datasource.url}")
    String jdbcUrl;

    public static void main(String[] args) {
        SpringApplication.run(J2021Application.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void startApp() {

    }
}
