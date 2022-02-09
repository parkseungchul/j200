package com.psc.sample.j206.controller.api;

import com.psc.sample.j206.dto.Dept;
import com.psc.sample.j206.dto.Result;
import com.psc.sample.j206.service.DeptService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@AllArgsConstructor
@RestController
public class RestDeptController {
    final DeptService deptService;
    @RequestMapping(value = "/dept.json", method = RequestMethod.GET)
    public Result deptGet(Integer deptNo){
        Dept dept = null;
        if(deptNo != null){
            dept = deptService.getDept(deptNo);
        }
        if(dept == null){
            return new Result("N");
        }else{
            return new Result("Y");
        }

    }
}
