package com.lny.springcloud.server;

import com.lny.springcloud.entities.Payment;
import com.lny.springcloud.utils.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "cloud-payment-server")
public interface PaymentFeignService {

    @GetMapping("/consumer/payment/get/{id}")
    CommonResult<Payment> queryById(@PathVariable("id") Long id);

}
