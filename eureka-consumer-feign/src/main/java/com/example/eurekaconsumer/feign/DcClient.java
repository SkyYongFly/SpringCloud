package com.example.eurekaconsumer.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * <p><
 *  Feign客户端 <br>
 *
 *  @FeignClient :声明需要调用的服务端应用名称
 * /p>
 *
 * @author zhuyong
 * @version V1.0.0
 * @date 2018/10/8 10:30
 */
@FeignClient("eureka-client")
public interface DcClient {

    /**
     * 通过SprinMVC方式来定义方法绑定的服务端REST接口
     *
     * @return
     */
    @GetMapping("/dc")
    String consumer();
}
