package com.gen.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.ZonedDateTime;

@Configuration
public class GateWayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();

        return routes.route("path_route_baidu",
                r -> r.path("/guonei")
                        .uri("http://news.baidu.com/guonei")).build();
    }

    public static void main(String[] args) {
        ZonedDateTime zdt = ZonedDateTime.now(); //默认时区
        System.out.println(zdt);
    }

}
