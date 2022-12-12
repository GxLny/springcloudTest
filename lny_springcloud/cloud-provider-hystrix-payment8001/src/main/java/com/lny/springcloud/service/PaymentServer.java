package com.lny.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentServer {

    @Value("${server.port}")
    public String serverPort;

    //成功
    public String paymentInfo_OK(Long id){
        return "线程池："+Thread.currentThread().getName()+"  paymentInfo_OK,id::"+id;
    }
    //超时

    /**
     * 加入服务降级注解
     * 3秒中属于业务正常逻辑
     * @fallbackMethod 处理问题的方法
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentsInfo_timeoutHandler",commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")})
    public String paymentsInfo_timeout(Long id){
        //设置超时异常
        int timeout = 5;
        try { TimeUnit.SECONDS.sleep(timeout); }catch (Exception e) {e.printStackTrace();}
        //计算异常
//        int age = 10/0;
        return "线程池："+Thread.currentThread().getName()+id;
    }

    //兜底方法
    public String paymentsInfo_timeoutHandler(Long id){

        return "线程池："+Thread.currentThread().getName()+"   系统繁忙或系统出错, 请稍候再试  ,id：  "+id+"\t"+"哭了哇呜";
    }



}
