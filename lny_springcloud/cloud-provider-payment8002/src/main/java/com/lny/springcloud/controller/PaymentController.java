package com.lny.springcloud.controller;

import com.lny.springcloud.entities.Payment;
import com.lny.springcloud.service.PaymentService;
import com.lny.springcloud.utils.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/add")
    public CommonResult add(@RequestBody Payment payment){
        int i = paymentService.add(payment);
        if (i > 0) {
            return new CommonResult(200,"插入成功，serverPort："+serverPort,i);
        }else{
            return new CommonResult(400,"插入失败！",null);
        }
    }

    @GetMapping("/get/{id}")
    public CommonResult queryById(@PathVariable("id") Long id){
        Payment payment = paymentService.queryById(id);
        if (payment != null) {
            return new CommonResult(200,"查询成功，serverPort："+serverPort,payment);
        }else{
            return new CommonResult(400,"查询失败！",null);
        }

    }



}
