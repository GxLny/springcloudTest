package com.lny.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {


    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
        //得到routers 类似配置文件的routers
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("baidu_route",r -> r.path("/guoji").uri("https://news.baidu.com/guonei")).build();
        return routes.build();
    }

}
