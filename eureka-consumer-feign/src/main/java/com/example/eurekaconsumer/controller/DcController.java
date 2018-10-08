package com.example.eurekaconsumer.controller;

import com.example.eurekaconsumer.feign.DcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Spring Cloud 消费者测试请求控制器：消费eureka-client中的接口
 *
 * @author  zhuyong
 * @date    2018/10/8 9:47
 * @version V1.0.0
 */
@RestController
public class DcController {
    @Autowired
    private DcClient dcClient;

    /**
     * 通过定义的Feign客户端来调用服务端REST接口
     *
     * @return
     */
    @GetMapping("/consumer")
    public String dc(){
        return dcClient.consumer();
    }
}
