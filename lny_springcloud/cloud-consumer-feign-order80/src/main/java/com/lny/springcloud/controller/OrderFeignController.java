package com.lny.springcloud.controller;

import com.lny.springcloud.entities.Payment;
import com.lny.springcloud.service.PaymentFeignService;
import com.lny.springcloud.utils.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/consumer")
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> queryById(@PathVariable("id") Long id){
        return paymentFeignService.queryById(id);
    }

    /**
     * 超时接口
     * @return
     */
    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout(){
        return paymentFeignService.paymentFeignTimeout();
    }

}
