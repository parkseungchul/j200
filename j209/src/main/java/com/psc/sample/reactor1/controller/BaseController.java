package com.psc.sample.reactor1.controller;

import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.reactive.result.view.Rendering;
import reactor.core.publisher.Mono;

@Controller
public class BaseController {

    @GetMapping
    Mono<Rendering> base(Model model){
        return Mono.just(Rendering.view("base.html")
        .modelAttribute("key", "value" ).build());
    }
}
