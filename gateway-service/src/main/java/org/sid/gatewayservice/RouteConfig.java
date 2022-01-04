package org.sid.gatewayservice;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;


public class RouteConfig {

  /*  @Bean
    RouteLocator staticRoute(RouteLocatorBuilder builder){
        return builder.routes()
                .route(r->r.path("/customers/**").uri("http://localhost:8081/") .id("r1"))
                .route(r->r.path("/products/**").uri("http://localhost:8082/"))
                .build();
    }*/

}
