package com.psc.sample.webflux.router;

import com.psc.sample.webflux.handler.BaseHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class BaseRouter {
    @Bean
    public RouterFunction<ServerResponse> list(BaseHandler handler){
        RouterFunction<ServerResponse> route = route()
                .GET("/", accept(MediaType.TEXT_HTML), handler::list) // (1)
                .POST("/", accept(MediaType.TEXT_HTML), handler::list) // (2)
                .build();
        return route;
    }

    @Bean
    public RouterFunction<ServerResponse> add(BaseHandler handler){
        RouterFunction<ServerResponse> route = route()
                .GET("/add", accept(MediaType.TEXT_HTML), handler::add) // (1)
                .POST("/add", accept(MediaType.TEXT_HTML), handler::add) // (2)
                .build();
        return route;
    }

    @Bean
    public RouterFunction<ServerResponse> addView(BaseHandler handler){
        RouterFunction<ServerResponse> route = route()
                .GET("/addView", accept(MediaType.TEXT_HTML), handler::addView) // (1)
                .POST("/addView", accept(MediaType.TEXT_HTML), handler::addView) // (2)
                .build();
        return route;
    }



    /**
     return RouterFunctions.route(
     RequestPredicates
     .GET("/")
     .and(
     RequestPredicates.accept(MediaType.TEXT_HTML)
     )
     ,
     (serverRequest) -> baseHandler.index(serverRequest)
     //baseHandler::index
     );
     **/
}
