package com.psc.sample.webflux.domain;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface DeptRepository extends ReactiveCrudRepository<DeptEntity, Integer> {

    Mono<DeptEntity> findDeptEntitiesByDeptNo(int deptNo);

}