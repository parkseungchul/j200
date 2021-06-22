package com.psc.sample.web.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@ExtendWith(SpringExtension.class)
@SpringBootTest(properties = {"spring.data.mongodb.host: localhost"})
public class TestDeptRepository {

    @Autowired
    DeptRepository repository;

    @Test
    public void setupDb(){
        repository.deleteAll();
        DeptEntity deptEntity = new DeptEntity(1,"1", "1");
        repository.save(deptEntity);
        System.out.println(repository.findById(1).get().toString());

    }

}
