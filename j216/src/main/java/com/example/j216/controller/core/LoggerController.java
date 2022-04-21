package com.example.j216.controller.core;

import com.example.j216.core.LoggerUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LoggerController {

    @RequestMapping("/logger")
    public String logger(String packageName, String level){
        boolean isResult = LoggerUtil.setLevel(packageName,level);
        return String.valueOf(isResult);
    }
}
