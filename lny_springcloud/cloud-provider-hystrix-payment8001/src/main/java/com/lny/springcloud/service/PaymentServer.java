package com.lny.springcloud.service;

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
    public String paymentsInfo_timeout(Long id){
        int timeout = 3;
        try { TimeUnit.SECONDS.sleep(timeout); }catch (Exception e) {e.printStackTrace();}
        return "线程池："+Thread.currentThread().getName()+id+" timeout:"+timeout;
    }

}
