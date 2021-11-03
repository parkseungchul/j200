package com.psc.sample.reactor2.controller;

import com.psc.sample.reactor2.domain.Cart;
import com.psc.sample.reactor2.repository.CartReactiveRepository;
import com.psc.sample.reactor2.repository.ItemReactiveRepository;
import com.psc.sample.reactor2.service.CartService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.reactive.result.view.Rendering;
import reactor.core.publisher.Mono;

@Controller
@AllArgsConstructor
public class BaseController {

    private ItemReactiveRepository itemReactiveRepository;
    private CartReactiveRepository cartReactiveRepository;
    private CartService cartService;

    @GetMapping
    Mono<Rendering> base(){
        return Mono.just(Rendering.view("base.html")
        .modelAttribute("items", itemReactiveRepository.findAll())
        .modelAttribute("cart", cartReactiveRepository.findById("My Cart")
                .defaultIfEmpty(new Cart("My Cart"))).build());
    }

    @PostMapping("/add/{id}")
    Mono<String> addCart2(@PathVariable String id){
        return cartService.addToCart("My Cart", id).thenReturn("redirect:/");
    }

    @DeleteMapping("delCartCount/{id}")
    Mono<String> delToCartCount(@PathVariable String id){
        return cartService.delToCartCount("My Cart", id).thenReturn("redirect:/");
    }

    @DeleteMapping("/delCartAll/{id}")
    Mono<String> delToCartAll(@PathVariable String id) {
        return cartService.delToCartAll("My Cart", id).thenReturn("redirect:/");
    }

    @DeleteMapping("/delItem/{id}")
    Mono<String> deleteItem(@PathVariable String id) {
        return this.itemReactiveRepository.deleteById(id) //
                .thenReturn("redirect:/");
    }
}
