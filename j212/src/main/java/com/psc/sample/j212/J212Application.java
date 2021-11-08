package com.psc.sample.j212;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class J212Application {


    @Value("${custom.area}")
    private String area;

    public static void main(String[] args) {
        SpringApplication.run(J212Application.class, args);
    }

    @RequestMapping("/")
    public String test(){
        return "IT 정답은 읎다.";
    }


    @Bean
    public ServletWebServerFactory servletContainer() {
        TomcatServletWebServerFactory tomcat = null;

        if(area.equals("multi")){
            tomcat = new TomcatServletWebServerFactory();
        }else if(area.equals("forward")){
            tomcat = new TomcatServletWebServerFactory();
        }else{
            tomcat  = new TomcatServletWebServerFactory() {
                @Override
                protected void postProcessContext(Context context) {
                    SecurityConstraint securityConstraint = new SecurityConstraint();
                    securityConstraint.setUserConstraint("CONFIDENTIAL");
                    SecurityCollection collection = new SecurityCollection();
                    collection.addPattern("/*");
                    securityConstraint.addCollection(collection);
                    context.addConstraint(securityConstraint);
                }
            };
        }
        tomcat.addAdditionalTomcatConnectors(createStandardConnector());
        return tomcat;
    }

    private Connector createStandardConnector() {
        Connector connector =
                new Connector("org.apache.coyote.http11.Http11NioProtocol");

        if(area.equals("multi")){
            // 추가 포트
            connector.setPort(8080);
        }else if(area.equals("forward")){
            // 기존 포트
            connector.setPort(8080);
            // 변경 포트
            connector.setRedirectPort(80);
        }else{
            connector.setScheme("http");
            connector.setSecure(false);
            connector.setPort(80);
            connector.setRedirectPort(443);
        }

        return connector;
    }

}
