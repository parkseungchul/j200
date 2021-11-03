package com.psc.j209.controller;

import com.psc.j209.domain.Dept;
import com.psc.j209.domain.DeptRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Slf4j
@Controller
public class BaseController {

    @Autowired
    DeptRepository deptRepository;

    @RequestMapping("/")
    public String index(Model model){

        log.debug("controller index call 컨트롤러 테스트");

        Optional<Dept> deptOptional = deptRepository.findById(1);
        if(deptOptional.isPresent()){
            model.addAttribute("dept", deptOptional.get());
        }
        return "/index";
    }

}
