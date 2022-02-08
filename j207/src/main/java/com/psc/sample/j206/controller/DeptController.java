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

    @RequestMapping("/deptView")
    public String dept(Integer deptNo, Model model){

        boolean isNew = true;
        if(deptNo != null){
            model.addAttribute("dept",deptService.getDept(deptNo));
            isNew = false;
        }
        model.addAttribute("isNew", isNew);
        return "deptView";
    }



    @RequestMapping("/deptDelete")
    public String deptDelete(Integer deptNo, Model model){
        deptService.deleteDept(deptNo);
        return "forward:/";
    }

}
