package com.psc.j203.repository;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.psc.j203.domain.Dept;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
@ActiveProfiles("prod")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestDeptRepository {
	
	@Autowired
	private DeptRepository deptRepository;
	
	
	@BeforeEach
	public void before() {
		log.debug("#### DeptRepository Test ####");
	}
	
	@Test
	@Order(1)
	public void A001_DEPT_TABLE_입력() {
		List deptList = new ArrayList<Dept>();
		deptList.add(new Dept(10, "ACCOUNTING" , "NEW YORK"));
		deptList.add(new Dept(20, "RESEARCH"   , "DALLAS"));
		deptList.add(new Dept(30, "SALES"      , "CHICAGO"));
		deptList.add(new Dept(40, "OPERATIONS" , "BOSTON"));
		deptRepository.saveAll(deptList);
		
		Long deptCnt = deptRepository.count();
		log.debug(String.valueOf(deptCnt));
		Assertions.assertThat(4L).isEqualTo(deptRepository.count());
	}
	
	@Test
	@Order(2)
	public void A002_DEPT_TABLE_수정() {
		String changeDname = "ACCOUNTING2";
		deptRepository.save(new Dept(10, changeDname , "NEW YORK"));
		
		Dept dept = deptRepository.findById(10).get();
		log.debug(dept.toString());
		Assertions.assertThat(changeDname).isEqualTo(dept.getDname());
	}
	
	@Test
	@Order(3)
	public void A003_DEPT_TABLE_삭제() {
		Integer deptno = 10;
		Dept dept = new Dept();
		dept.setDeptno(10);
		deptRepository.delete(dept);
		
		boolean isPresent = deptRepository.findById(deptno).isPresent();
		log.debug(String.valueOf(isPresent));
		Assertions.assertThat(false).isEqualTo(isPresent);
	}
	
	
	
	
	
}
