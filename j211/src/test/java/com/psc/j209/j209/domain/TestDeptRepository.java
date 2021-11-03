package com.psc.j209.j209.domain;

import com.psc.j209.domain.Dept;
import com.psc.j209.domain.DeptRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

@DataJpaTest
public class TestDeptRepository {

    @Autowired
    DeptRepository deptRepository;

    @BeforeEach
    public void setupDept(){
        Dept dept = new Dept(1,"1","1");
        deptRepository.save(dept);
    }

    @Test
    public void selectDept(){
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@");
        deptRepository.findAll().forEach(dept -> {
            System.out.println(dept.toString());
        });
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@");
    }
}
