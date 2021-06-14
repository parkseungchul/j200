package com.psc.sample.webflux.dto;

import lombok.*;
import reactor.core.publisher.Flux;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DefaultDto {

    private String msg;
    private boolean result;
    private List<Integer> stringFlux;
}
