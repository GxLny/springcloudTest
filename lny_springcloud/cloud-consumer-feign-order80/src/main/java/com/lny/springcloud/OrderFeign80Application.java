package com.lny.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@EnableFeignClients
public class OrderFeign80Application {
    public static void main(String[] args) {

        SpringApplication.run(OrderFeign80Application.class,args);
    }
}
