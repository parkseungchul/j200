package com.psc.cloud.j204.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping(value = "/permitAll", method = RequestMethod.GET)
    public ResponseEntity<String> permitAll() {
        return ResponseEntity.ok("누구나 접근이 가능합니다.\n");
    }

    @RequestMapping(value = "/authenticated", method = RequestMethod.GET)
    public ResponseEntity<String> authenticated(@RequestHeader String Authorization) {
        log.debug(Authorization);
        return ResponseEntity.ok("로그인한 사람 누구나 가능합니다.\n");
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<String> user(@RequestHeader String Authorization) {
        log.debug(Authorization);
        return ResponseEntity.ok("user 가능합니다.\n");
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ResponseEntity<String> admin(@RequestHeader String Authorization) {
        log.debug(Authorization);
        return ResponseEntity.ok("admin 가능합니다.\n");
    }

}
