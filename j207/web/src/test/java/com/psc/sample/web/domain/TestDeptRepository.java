package com.psc.sample.web.domain;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

@ExtendWith(SpringExtension.class)
@DataMongoTest
public class TestDeptRepository {

    @Autowired
    DeptRepository repository;

    @Test
    public void deptTable(){
        repository.deleteAll();
        DeptEntity deptEntity = new DeptEntity(1,"1", "1");
        repository.save(deptEntity);
        System.out.println(repository.findById(1).get().toString());
    }

}
