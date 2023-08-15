package com.lny.springloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.lny.springcloud.entities.Payment;
import com.lny.springcloud.utils.CommonResult;
import com.lny.springloud.myHandler.CustomerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RateLimitController {

    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handlerException1")
    public CommonResult customerBlockHandler()
    {
        return new CommonResult(200,"按url限流测试OK",new Payment(2020L,"serial002"));
    }


}
