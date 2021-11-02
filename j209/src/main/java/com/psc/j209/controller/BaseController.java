package com.psc.j209.controller;

import com.psc.j209.domain.Dept;
import com.psc.j209.domain.DeptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class BaseController {

    @Autowired
    DeptRepository deptRepository;

    @RequestMapping("/")
    public String index(Model model){
        Optional<Dept> deptOptional = deptRepository.findById(1);
        if(deptOptional.isPresent()){
            model.addAttribute("dept", deptOptional.get());
        }
        return "index";
    }

}
