package com.psc.sample.reactor2.repository;

import com.psc.sample.reactor2.domain.Item;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ItemReactiveRepository extends ReactiveCrudRepository<Item,String>, ReactiveQueryByExampleExecutor<Item> {

    Flux<Item> findByNameContaining(String itemName);
    Mono<Item> findByName(String name);
}
