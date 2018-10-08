package com.example.eurekaconsumer.controller;

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
 * @date    2018/10/8 9:47
 * @version V1.0.0
 */
@RestController
public class DcController {
    //负载均衡客户端
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    //发起REST请求对象
    @Autowired
    private RestTemplate restTemplate;

    /**
     * REST请求消费Eureka服务端消息
     *
     * @return
     */
    @GetMapping("/consumer")
    public String dc(){
//        ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-client");
//        //获取服务端接口地址（这里直接硬编码写死）
//        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/dc";
//        System.out.println("服务端地址：" + url);
//        return restTemplate.getForObject(url, String.class);

        //这里请求服务接口并没有直接设置IP以及端口，而是采用请求服务端应用名称方式，
        //实际运行时，ribbon自动的去选取服务实例，并将实际要请求的IP地址和端口替换这里的服务名，从而完成服务接口的调用
        return restTemplate.getForObject("http://eureka-client/dc", String.class);
    }
}
