package com.psc.sample.j213.controller;

import com.psc.sample.j213.dto.Dept;
import com.psc.sample.j213.service.DeptService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// lombok 에서 사용하는 어노테이션들을 상위로 올리는 것이 국룰 왜냐 나중에 코틀린 전환할때 편해유.
@Slf4j
@AllArgsConstructor
@Controller
public class DeptController {

    final DeptService deptService;

    @GetMapping("/")
    public String deptList(Model model){
        model.addAttribute("deptList", deptService.deptList());
        return "deptList";
    }

    @RequestMapping(value = "/dept", method = RequestMethod.GET)
    public String dept(Integer deptNo, Model model){
        String isNew = "Y";
        if(deptNo != null){
            model.addAttribute("dept",deptService.getDept(deptNo));
            isNew = "N";
        }
        model.addAttribute("isNew", isNew);
        return "deptView";
    }

    @RequestMapping(value = "/dept", method = { RequestMethod.POST, RequestMethod.PUT})
    public String deptPut(Dept dept, Model model){
        deptService.addDept(dept);
        //return "redirect:/dept?deptNo="+dept.getDeptNo();
        return "redirect:/";
    }

    @RequestMapping(value = "/dept", method = RequestMethod.DELETE)
    public String deptDelete(Integer deptNo, Model model){
        log.debug("delete: deptNo = " + deptNo);
        deptService.deleteDept(deptNo);
        return "redirect:/";
    }

}
