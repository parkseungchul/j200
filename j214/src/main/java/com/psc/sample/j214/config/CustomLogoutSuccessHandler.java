package com.psc.sample.j214.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
public class CustomLogoutSuccessHandler implements LogoutSuccessHandler {
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response,
                                Authentication authentication) throws IOException, ServletException {




        String id = "";
        if (authentication != null && authentication.getDetails() != null) {
            try {
                SecurityUser securityUser = (SecurityUser) authentication.getPrincipal();
                id = securityUser.getMember().getId();

            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                request.getSession().invalidate();
            }
        }
        response.setStatus(HttpServletResponse.SC_OK);
        response.sendRedirect("/");
        //response.sendRedirect("/login/?id=" + id);
    }
}
