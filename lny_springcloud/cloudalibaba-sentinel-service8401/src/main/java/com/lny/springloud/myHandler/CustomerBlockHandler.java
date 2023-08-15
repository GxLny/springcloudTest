package com.lny.springloud.myHandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.lny.springcloud.utils.CommonResult;

public class CustomerBlockHandler {

    public static CommonResult handlerException1(BlockException exception){
        return new CommonResult(2023,"自定义限流处理--1");
    }
    public static CommonResult handlerException2(BlockException exception){
        return new CommonResult(2023,"自定义限流处理--2");
    }
}
