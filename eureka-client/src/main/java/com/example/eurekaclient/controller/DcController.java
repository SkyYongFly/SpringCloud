package com.example.eurekaclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *  服务信息测试请求处理控制器
 *
 * @author  zhuyong
 * @date    2018/10/8 9:29
 * @version V1.0.0
 */
@RestController
public class DcController {
    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("/dc")
    public String dc() throws Exception{
    //    Thread.sleep(5000L); //测试休眠一段时间，以测试断路器功能
        String services = "Services: " + discoveryClient.getServices();
        System.out.println(services);
        return services;
    }
}
