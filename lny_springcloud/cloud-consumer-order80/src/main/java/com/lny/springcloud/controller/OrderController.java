package com.lny.springcloud.controller;

import com.lny.springcloud.entities.Payment;
import com.lny.springcloud.utils.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/consumer")
public class OrderController {

//    public static final String PAYMENT_URL = "http://localhost:8001";
    // 使用eureka注册中心的服务名称
    public static final String PAYMENT_URL = "http://cloud-payment-server";
    /**
     * 远程调用服务接口
     */
    @Resource
    private RestTemplate restTemplate;
    /**
     * 服务发现
     */
    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/payment/add")
    public CommonResult<Payment> add(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/add",payment,CommonResult.class);
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> queryById(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }

    /**
     * 获取服务信息
     * @return
     */
    @GetMapping("/payment/discovery")
    public Object discovery(){
        // 获取所有注册的服务
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("------service::"+service);
        }
        //获取指定服务信息
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVER");
        for (ServiceInstance instance : instances) {
            log.info("instance::"+instance.getServiceId()+"             "+instance.getHost()+"   "+instance.getPort()+"     "+instance.getUri());
        }

        return this.discoveryClient;
    }


}
