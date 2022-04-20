package com.example.j216.controller.core;

import com.example.j216.core.LoggerUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoggerController {

    @RequestMapping("/logger")
    public void logger(String name, String level){

        LoggerUtil.setLevel("com.example","ERROR");
    }
}
