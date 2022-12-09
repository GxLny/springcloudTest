package com.lny.springcloud.service;

import com.lny.springcloud.entities.Payment;
import com.lny.springcloud.utils.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "cloud-payment-server")
public interface PaymentFeignService {

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @GetMapping("/payment/get/{id}")
    CommonResult<Payment> queryById(@PathVariable("id") Long id);

    /**
     * 超时接口
     * @return
     */
    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout();

}
