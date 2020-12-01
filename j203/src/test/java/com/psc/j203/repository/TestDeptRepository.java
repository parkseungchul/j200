package com.psc.j203.repository;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.psc.j203.domain.Dept;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class TestDeptRepository {

	
	@Autowired
	private DeptRepository deptRepository;
	
	
	@Test
	public void A001_부서_입력() {
		
		List deptList = new ArrayList<Dept>();
		deptList.add(new Dept(10, "ACCOUNTING" , "NEW YORK"));
		deptList.add(new Dept(20, "RESEARCH"   , "DALLAS"));
		deptList.add(new Dept(30, "SALES"      , "CHICAGO"));
		deptList.add(new Dept(40, "OPERATIONS" , "BOSTON"));
		deptRepository.saveAll(deptList);
		
		Assertions.assertThat(4L).isEqualTo(deptRepository.count());
		deptRepository.findAll().forEach(dept ->{
			log.debug(dept.toString());
			}
		 );



		
	}
}
