package com.lny.springcloud.controller;

import cn.hutool.core.lang.UUID;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    /**
     * 测试获取端口号
     * @return
     */
    @GetMapping("/consul")
    public String paymentConsul(){
        return "consulPort:"+serverPort+"   "+ UUID.randomUUID().toString();
    }


}
