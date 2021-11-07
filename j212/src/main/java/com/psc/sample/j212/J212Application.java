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

        if(area.equals("ssh")){
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
        }else{
            tomcat = new TomcatServletWebServerFactory();
        }
        tomcat.addAdditionalTomcatConnectors(createStandardConnector());


        return tomcat;
    }

    private Connector createStandardConnector() {
        Connector connector =
                new Connector("org.apache.coyote.http11.Http11NioProtocol");

        if(area.equals("ssh")){
            connector.setScheme("http");
            connector.setSecure(false);
            connector.setPort(80);
            connector.setRedirectPort(443);
        }else{
            connector.setPort(80);
        }

        return connector;
    }

}
