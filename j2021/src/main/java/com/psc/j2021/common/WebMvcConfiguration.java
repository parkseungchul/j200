package com.psc.j2021.common;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@AllArgsConstructor
@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

    final Handler handler;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(handler);
    }
}
