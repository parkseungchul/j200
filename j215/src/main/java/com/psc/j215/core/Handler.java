package com.psc.j215.core;

import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.UUID;

@Slf4j
@Component
public class Handler implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String traceId = "";

        if( request.getCookies() != null){
            for(Cookie cookie: request.getCookies()){
                if(cookie.getName().equals("traceId")){
                    traceId = cookie.getValue();
                }
            }
        }


        HttpSession httpSession = request.getSession();
        if(traceId == null|| traceId.equals("")){
            traceId = UUID.randomUUID().toString();
            httpSession.setAttribute("traceId", traceId);
        }else{
            httpSession.setAttribute("traceId", traceId);
        }
        return true;
    }


    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                            @Nullable ModelAndView modelAndView) throws Exception {

        request.getSession().setAttribute("traceId", "");
    }
}
