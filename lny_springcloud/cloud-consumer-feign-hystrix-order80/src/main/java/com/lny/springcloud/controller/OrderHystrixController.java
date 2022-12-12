package com.lny.springcloud.controller;

import com.lny.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/consumer")
//@DefaultProperties(defaultFallback = "paymentGlobalFallbackMethod") //全局fallback方法
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
//    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod",commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")})
//    @HystrixCommand  //如果不指定方法，默认选用全局方法
    public String paymentInfo_timeout(@PathVariable("id") Long id){
//        int age = 10/0;
        String res = paymentHystrixService.paymentInfo_timeout(id);
        log.info("paymentInfo_timeout:::"+res);
        return res;
    }

    //兜底方法
    public String paymentTimeOutFallbackMethod(@PathVariable("id") Long id){
        return "我是消费者80，对付支付系统繁忙请10秒钟后再试或者自己运行出错请检查自己,(┬＿┬)";
    }

    /**
     * 全局方法
     * @return
     */
    public String paymentGlobalFallbackMethod(){
        return "系统繁忙，请稍后再试！！";
    }




}
