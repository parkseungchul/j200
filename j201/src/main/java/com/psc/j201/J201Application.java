package com.psc.j201;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

@SpringBootApplication
public class J201Application implements ApplicationListener<ApplicationReadyEvent>{

	@Value("${server.message}")
	String message;
	
	@Value("${server.codesN}")
	List codesN;
	
	@Value("${server.codesA}")
	List codesA;
	
	
	public static void main(String[] args) {
		SpringApplication.run(J201Application.class, args);
	}

	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		System.out.println(message);
		System.out.println(codesN.size() +" "+codesN.toString());
		System.out.println(codesA.size() +" "+codesA.toString());
		
	}
	
	

}
