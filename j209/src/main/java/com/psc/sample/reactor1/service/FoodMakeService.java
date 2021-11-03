package com.psc.sample.reactor1.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class FoodMakeService {

    private Random random = new Random();
    private List<Food> menu = Arrays.asList(
            new Food("pizza", false),
            new Food("pasta", false),
            new Food("hamburger", false)
    );

    private Food randomFood(){
        return menu.get(random.nextInt(menu.size()));
    }

    public Flux<Food> getFoods(){
        return Flux.<Food> generate(a -> a.next(randomFood())).delayElements(Duration.ofMillis(1000));
    }
}
