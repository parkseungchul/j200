package com.psc.sample.webflux.handler;

import com.psc.sample.webflux.dto.DefaultDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.*;

@Slf4j
@Component
public class BaseHandler {
    public Mono<ServerResponse> index(ServerRequest request){
        // Request get parameter
        final Map<String, Object> data = new HashMap<>();
        Optional<String> stringOptional = request.queryParam("msg");
        // flux to list with non-blocking

        Flux<Integer> flux = Flux.range(1, 100);

        List<Integer> list = new ArrayList<>();
        flux.collectList().subscribe(list::addAll);
        data.put("defaultDto", new DefaultDto(stringOptional.orElse("msg is not exist"), stringOptional.isPresent(),  list));
        return ServerResponse.ok().contentType(MediaType.TEXT_HTML).render("index", data);
    }
}
