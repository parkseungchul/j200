package com.psc.sample.j213;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@EnableJpaAuditing
@SpringBootApplication
public class J213Application {

    public static void main(String[] args) {
        SpringApplication.run(J213Application.class, args);
    }

}
