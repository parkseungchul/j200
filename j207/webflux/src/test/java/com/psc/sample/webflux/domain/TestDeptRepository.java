package com.psc.sample.webflux.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;


@ExtendWith(SpringExtension.class)
@DataMongoTest
public class TestDeptRepository {

    @Autowired
    DeptRepository repository;

    private DeptEntity savedEntity;


    @Autowired
    ReactiveMongoOperations mongoTemplate;

    @Test
    public void deptTable1(){
        StepVerifier.create(repository.deleteAll()).verifyComplete();
        DeptEntity deptEntity = new DeptEntity(Integer.parseInt("1"),"1", "1");
        StepVerifier.create(repository.save(deptEntity))
                .expectNextMatches(createdEntity -> {
                    savedEntity = createdEntity;
                    return areEqual(deptEntity, savedEntity);
                })
                .verifyComplete();
    }

    @Test
    public void deptTable2(){
        DeptEntity deptEntity = new DeptEntity(Integer.parseInt("1"),"1", "1");
        //mongoTemplate.insert(Mono.just(deptEntity));

        Mono<DeptEntity> newEntity = repository.save(deptEntity);

        newEntity.block();

    }


    private boolean areEqual(DeptEntity expectedEntity, DeptEntity actualEntity) {
        return
                (expectedEntity.getDeptNo() == actualEntity.getDeptNo()) &&
                        (expectedEntity.getdName().equals(actualEntity.getdName())) &&
                                (expectedEntity.getLoc().equals(actualEntity.getLoc()));

    }

}
