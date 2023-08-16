package com.lny.springcloud.service;

import com.lny.springcloud.entities.Payment;
import com.lny.springcloud.utils.CommonResult;
import org.springframework.stereotype.Component;


@Component
public class PaymentFallbackService implements PaymentService
{
    @Override
    public CommonResult<Payment> paymentSQL(Long id)
    {
        return new CommonResult<>(5000,"服务降级返回,---PaymentFallbackService",new Payment(id,"errorSerial"));
    }
}
