package com.lny.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * 统一为接口里面的方法进行异常处理
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService{
    public String paymentInfo_ok(Long id) {
        return "paymentInfo_ok，服务器连接异常，请稍后再试";
    }

    public String paymentInfo_timeout(Long id) {
        return "paymentInfo_timeout，服务器连接异常，请稍后再试";
    }
}
