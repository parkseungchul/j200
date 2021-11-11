package com.psc.sample.j213.service;

import com.psc.sample.j213.domain.Dept;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class TestDeptService {

    @Autowired
    DeptService deptService;

    public Dept saveDept(Dept dept){
        return deptService.saveDept(dept);
    }

    @Test
    public void getDept(){
        Dept dept = new Dept(10, "ACCOUNTING", "NEW YORK");
        saveDept(dept);
        System.out.println("1: " + deptService.getDept(dept.getDeptno()).toString());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        saveDept(dept);
        //dept = deptService.getDept(dept.getDeptno());
        System.out.println("2: " + dept.toString());
    }



}
