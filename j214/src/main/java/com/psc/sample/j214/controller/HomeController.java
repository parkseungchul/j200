package com.psc.sample.j214.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class HomeController {

    @RequestMapping("")
    public String main(){
        return "redirect:introduce";
    }

    @RequestMapping("/introduce")
    public String introduce(){
        return "introduce";
    }

    @RequestMapping("/charge")
    public String charge(){
        return "charge";
    }

    @RequestMapping("/information")
    public String information(){
        return "information";
    }

    @RequestMapping("/notice")
    public String notice(){
        return "notice";
    }

    @RequestMapping("/guide")
    public String guide(){
        return "guide";
    }

    @RequestMapping("/faq")
    public String faq(){
        return "faq";
    }

    @RequestMapping("/signIn")
    public String signIn(){
        return "signIn";
    }

    @RequestMapping("/signUp")
    public String signUp(){
        return "signUp";
    }

    @RequestMapping("/free")
    public String free(){
        return "free";
    }

    @RequestMapping("/accessDenied")
    public String accessDenied() {
        return "accessDenied";
    }
}
