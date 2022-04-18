package com.psc.j215.core;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@ControllerAdvice("com")
public class ControllerException {

    @ExceptionHandler
    public String Exception(HttpServletRequest httpServletRequest, ModelMap modelMap, Exception e){
        httpServletRequest.getSession().setAttribute("traceId", "");
        modelMap.addAttribute("message", e.getMessage());
        return "error";

    }
}
