package com.lny.springcloud.controller;

import com.lny.springcloud.entities.Payment;
import com.lny.springcloud.service.PaymentService;
import com.lny.springcloud.utils.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

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
            return new CommonResult(200,"插入成功，serverPost："+serverPort,i);
        }else{
            return new CommonResult(400,"插入失败！",null);
        }
    }

    @GetMapping("/get/{id}")
    public CommonResult queryById(@PathVariable("id") Long id){
        Payment payment = paymentService.queryById(id);
        if (payment != null) {
            return new CommonResult(200,"查询成功，serverPost："+serverPort,payment);
        }else{
            return new CommonResult(400,"查询失败！",null);
        }

    }

    /**
     * 超时时间接口
     * @return
     */
    @GetMapping(value = "/feign/timeout")
    public String paymentFeignTimeout(){
        //设置超时时间
        try { TimeUnit.SECONDS.sleep(3); }catch (Exception e) {e.printStackTrace();}
        return serverPort;
    }



}
