package com.psc.sample.web.controller;

import com.psc.sample.web.domain.DeptEntity;
import com.psc.sample.web.service.WebService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@AllArgsConstructor
public class WebController {

    final WebService webService;

    @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.POST})
    public String list(Model model){
        model.addAttribute("list",  webService.listDept());
        return "list";
    }

    @RequestMapping(value = "/addView", method = {RequestMethod.GET, RequestMethod.POST})
    public String addView(Model model){
        return "addView";
    }

    @RequestMapping(value = "/add", method = {RequestMethod.GET, RequestMethod.POST})
    public String add(String deptNo,String dName, String loc){
        DeptEntity deptEntity = new DeptEntity(Integer.parseInt(deptNo), dName, loc);
        webService.addDept(deptEntity);
        return "forward:/";
    }

    @RequestMapping(value = "/delete", method = {RequestMethod.GET, RequestMethod.POST})
    public String delete(String deptNo){
        webService.deleteDept(Integer.parseInt(deptNo));
        return "forward:/";
    }
}
