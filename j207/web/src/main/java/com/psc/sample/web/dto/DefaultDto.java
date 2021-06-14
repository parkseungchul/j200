package com.psc.sample.web.dto;

import lombok.*;

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
