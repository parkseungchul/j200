package com.psc.sample.j206.controller;

import com.psc.sample.j206.service.DeptService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
public class DeptController {

    final DeptService deptService;

    @RequestMapping("/")
    public String deptList(Model model){
        model.addAttribute("deptList", deptService.deptList());
        return "deptList";
    }

    @RequestMapping("/dept")
    public String dept(Integer deptNo, Model model){
        model.addAttribute("dept",deptService.getDept(deptNo));
        return "dept";
    }

    @RequestMapping("/deptDelete")
    public String deptDelete(Integer deptNo, Model model){
        deptService.deleteDept(deptNo);
        return "forward:/";
    }

}
