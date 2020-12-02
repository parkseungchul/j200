package com.psc.j203;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

import com.psc.j203.domain.Dept;
import com.psc.j203.repository.DeptRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class J203Application implements ApplicationListener<ApplicationReadyEvent>{

	@Autowired
	private DeptRepository deptRepository;
	
	@Value("${server.message}")
	String message;
	
	public static void main(String[] args) {
		SpringApplication.run(J203Application.class, args);
	}

	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		// TODO Auto-generated method stub
		log.debug("[" + message + "]");

		List deptList = new ArrayList<Dept>();
		deptList.add(new Dept(10, "ACCOUNTING" , "NEW YORK"));
		deptList.add(new Dept(20, "RESEARCH"   , "DALLAS"));
		deptList.add(new Dept(30, "SALES"      , "CHICAGO"));
		deptList.add(new Dept(40, "OPERATIONS" , "BOSTON"));
		deptRepository.saveAll(deptList);

	}

}
