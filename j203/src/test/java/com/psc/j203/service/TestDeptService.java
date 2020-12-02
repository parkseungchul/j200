package com.psc.j203.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.psc.j203.domain.Dept;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
@ActiveProfiles("prod")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestDeptService {
	
	@Autowired
	private DeptService deptService;
	
	
	@BeforeEach
	public void before() {
		log.debug("↓↓↓↓↓ DeptService Test ↓↓↓↓↓");
	}
	
	@AfterEach
	public void after() {
		log.debug("↑↑↑↑↑ DeptService Test ↑↑↑↑↑");
	}
	
	

	@Test
	@Order(1)
	public void A001_DEPT_SVC_입력() {
		List<Dept> deptList = new ArrayList<Dept>();
		deptList.add(new Dept(10, "ACCOUNTING" , "NEW YORK"));
		deptList.add(new Dept(20, "RESEARCH"   , "DALLAS"));
		deptList.add(new Dept(30, "SALES"      , "CHICAGO"));
		deptList.add(new Dept(40, "OPERATIONS" , "BOSTON"));
		for(Dept dept: deptList) {
			deptService.save(dept);
		}
		Long deptCnt = deptService.count();
		log.debug(String.valueOf(deptCnt));
		Assertions.assertThat(deptList.size()).isEqualTo(deptCnt.intValue());

	}
	
	@Test
	@Order(2)
	public void A002_DEPT_SVC_수정() {
		String changeDname = "ACCOUNTING2";
		deptService.save(new Dept(10, changeDname , "NEW YORK"));
		Dept dept = deptService.getDept(10).get();
		log.debug(dept.toString());
		Assertions.assertThat(changeDname).isEqualTo(dept.getDname());
	}
	
	@Test
	@Order(3)
	public void A003_DEPT_SVC_삭제() {
		Integer deptno = 10;
		deptService.delete(deptno);
		
		boolean isPresent = deptService.getDept(deptno).isPresent();
		log.debug(String.valueOf(isPresent));
		Assertions.assertThat(false).isEqualTo(isPresent);
	}
	
	
	
	
	
}
