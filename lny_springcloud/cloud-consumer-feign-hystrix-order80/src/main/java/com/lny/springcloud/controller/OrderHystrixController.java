package com.lny.springcloud.controller;

import com.lny.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/consumer")
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;


    @GetMapping("/hystrix/ok/{id}")
    public String paymentInfo_ok(@PathVariable("id") Long id){
        String res = paymentHystrixService.paymentInfo_ok(id);
        log.info("paymentInfo_ok:::"+res);
        return res;
    }

    @GetMapping("/hystrix/timeout/{id}")
    public String paymentInfo_timeout(@PathVariable("id") Long id){
        String res = paymentHystrixService.paymentInfo_timeout(id);
        log.info("paymentInfo_timeout:::"+res);
        return res;
    }



}
