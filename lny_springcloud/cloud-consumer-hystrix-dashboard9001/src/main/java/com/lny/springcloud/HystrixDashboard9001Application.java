package com.lny.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard //开启服务监控
public class HystrixDashboard9001Application {

    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboard9001Application.class);

    }


}
