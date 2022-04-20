package com.example.j216.controller.app;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class RestTestController {

    @RequestMapping("/")
    public String index(){

        log.trace("trace");
        log.debug("debug");
        log.info("info");
        log.error("error");

        return "test";
    }
}
