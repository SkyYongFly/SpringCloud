package com.example.eurekaconsumer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

/**
 * 采用断路器的请求处理控制器
 *
 * @author  zhuyong
 * @date    2018/10/8 16:27
 * @version V1.0.0
 */
@Controller
public class ConsumerService {
    @Autowired
    RestTemplate restTemplate;

    /**
     * 当前请求出现问题的时候，转而使用 @HystrixCommand 注解声明的 fallback 方法进行处理
     */
    @HystrixCommand(fallbackMethod = "fallback")
    public String consumer(){
        return restTemplate.getForObject("http://eureka-client/dc", String.class);
    }

    public String fallback(){
        return "原请求出现故障，转为本请求 —— fallback处理......";
    }
}
