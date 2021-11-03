package com.psc.sample.reactor2.repository;

import com.psc.sample.reactor2.domain.Cart;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface CartReactiveRepository extends ReactiveCrudRepository<Cart, String> {
}
