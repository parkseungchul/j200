package com.psc.sample.j213.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;

@DataJpaTest
public class TestDeptEmpRepository {

    @Autowired
    DeptRepository deptRepository;

    public void setupDept(){
        ArrayList<Dept> arrayList = new ArrayList<Dept>();
        arrayList.add(new Dept(10, "ACCOUNTING", "NEW YORK"));
        arrayList.add(new Dept(20, "RESEARCH",   "DALLAS"));
        arrayList.add(new Dept(30, "SALES",      "CHICAGO"));
        arrayList.add(new Dept(40, "OPERATIONS", "BOSTON"));


        deptRepository.saveAll(arrayList);




    }

    @Test
    public void deptList(){
        deptRepository.findAll().forEach(dept -> {
            System.out.println(dept.toString());
        });
    }

    @Test
    public void deptUpdate(){

        Dept dept = new Dept(10,"10", "10");
        deptRepository.save(dept);

        System.out.println(deptRepository.findById(10).get().toString());
    }
}
