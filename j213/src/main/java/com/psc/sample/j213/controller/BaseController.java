package com.psc.sample.j213.controller;

import com.psc.sample.j213.domain.Dept;
import com.psc.sample.j213.service.DeptService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class BaseController {

    final DeptService deptService;

    @RequestMapping("/")
    public Dept add(){
        return deptService.saveDept(new Dept(10, "ACCOUNTING", "NEW YORK"));
    }
}
