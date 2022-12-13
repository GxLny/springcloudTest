package com.lny.springcloud.controller;

import com.lny.springcloud.service.PaymentServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Value("${server.port}")
    public String serverPort;

    @Resource
    private PaymentServer paymentServer;

    @GetMapping("/hystrix/ok/{id}")
    public String paymentInfo_ok(@PathVariable Long id){
        String res = paymentServer.paymentInfo_OK(id);
        log.info("paymentInfo_ok:::"+res);
        return res;
    }

    @GetMapping("/hystrix/timeout/{id}")
    public String paymentInfo_timeout(@PathVariable Long id){
        String res = paymentServer.paymentsInfo_timeout(id);
        log.info("paymentInfo_timeout:::"+res);
        return res;
    }

    //===服务熔断
    @GetMapping("/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        String result = paymentServer.paymentCircuitBreaker(id);
        log.info("*******result:"+result);
        return result;
    }

}
