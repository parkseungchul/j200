package com.psc.j215.controller;

import com.psc.j215.service.DeptService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@AllArgsConstructor
@Controller
public class DeptController {

    final DeptService deptService;


    @RequestMapping("/")
    public String main(ModelMap modelMap){

        log.debug("main 1");
        deptService.deptList();
        modelMap.addAttribute("deptList", deptService.deptList());
        log.trace("trace");
        log.debug("debug");
        log.error("error");
        return "main";
    }

}
