package com.psc.j202;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class J202Application implements ApplicationListener<ApplicationReadyEvent>{

	public static void main(String[] args) {
		SpringApplication.run(J202Application.class, args);
	}

	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		// TODO Auto-generated method stub
		log.debug("debug");
		log.warn("warn");
		log.info("info");
		log.error("error");
	}

}
