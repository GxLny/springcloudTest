package com.lny.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    Logger.Level feignLoggerLevel(){

        /**
         * 日志级别：
         * NODE :默认，不显示任何日志
         * BASIC：记录请求方法，url，相应状态码及执行时间
         * HEADERS：除了BASIC之外，加上请求和相应的头信息
         * FULL ：除了HEADERS之外，加上请求和相应的正文及元数据
         */
        return Logger.Level.FULL;
    }

}
