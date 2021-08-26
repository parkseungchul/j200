package com.psc.sample.webflux.handler;

import com.psc.sample.webflux.domain.DeptEntity;
import com.psc.sample.webflux.domain.DeptRepository;
import com.psc.sample.webflux.dto.DefaultDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
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


    @Autowired
    DeptRepository deptRepository;

    public Mono<ServerResponse> list(ServerRequest request){
        // Request get parameter
        final Map<String, Object> data = new HashMap<>();
        Optional<String> stringOptional = request.queryParam("msg");
        // flux to list with non-blocking


        Flux<Integer> flux = Flux.range(1, 100);

        List<Integer> list = new ArrayList<>();
        flux.collectList().subscribe(list::addAll);
        data.put("defaultDto", new DefaultDto(stringOptional.orElse("msg is not exist"), stringOptional.isPresent(),  list));


        Flux<DeptEntity> flux2 = mongoTemplate.findAll(DeptEntity.class);
        List<DeptEntity> list2 = new ArrayList<>();

        flux2.collectList().subscribe(list2::addAll);
        data.put("list", list2);


        return ServerResponse.ok().contentType(MediaType.TEXT_HTML).render("list", data);
    }

    @Autowired
    ReactiveMongoOperations mongoTemplate;


    public Mono<ServerResponse> add(ServerRequest request){

        final Map<String, Object> data = new HashMap<>();
        Mono<DeptEntity> deptEntityMono = request.bodyToMono(DeptEntity.class);

        deptEntityMono.map(x -> {
            System.out.println("======================>"+x.toString());
            Mono<DeptEntity> deptEntityMono1 = deptRepository.save(x);
                    deptEntityMono.block();
            return x;
        }
        );

        return list(request);
    }

    public Mono<ServerResponse> addView(ServerRequest request){
        final Map<String, Object> data = new HashMap<>();
        return ServerResponse.ok().contentType(MediaType.TEXT_HTML).render("addView", data);
    }
}
