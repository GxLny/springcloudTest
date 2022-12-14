package com.lny.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient  //开启服务发现
public class Payment9002Application {

    public static void main(String[] args) {
        SpringApplication.run(Payment9002Application.class,args);
    }
}
