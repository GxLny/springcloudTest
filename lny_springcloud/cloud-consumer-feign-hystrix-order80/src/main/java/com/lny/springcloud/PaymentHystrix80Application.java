package com.lny.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PaymentHystrix80Application {

    public static void main(String[] args) {
        SpringApplication.run(PaymentHystrix80Application.class,args);
    }
}
