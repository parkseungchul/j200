package com.psc.sample.web.controller;

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
    public String index(String msg, Model model){
        model.addAttribute("defaultDto", webService.get(msg));
        return "index";
    }
}
