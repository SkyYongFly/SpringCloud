package com.example.eurekaconsumer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Spring Cloud 消费者测试请求控制器：消费eureka-client中的接口
 *
 * @author  zhuyong
 * @date    2018/10/8 16:19
 * @version V2.0.0
 */
@RestController
public class DcController {
    @Autowired
    ConsumerService consumerService;

    @GetMapping("/consumer")
    public String dc(){
        return consumerService.consumer();
    }
}
