package com.psc.sample.reactor1.controller.api;

import com.psc.sample.reactor1.service.Food;
import com.psc.sample.reactor1.service.FoodMakeService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@AllArgsConstructor
public class BaseApiController {

    FoodMakeService foodMakeService;

    @GetMapping(value = "/1", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Flux<Food> makeFoods1(){
        return foodMakeService.getFoods();
    }

    @GetMapping(value = "/2", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Flux<Food> makeFoods2(){
        return foodMakeService.getFoods().map(food -> Food.status(food));
    }

}
