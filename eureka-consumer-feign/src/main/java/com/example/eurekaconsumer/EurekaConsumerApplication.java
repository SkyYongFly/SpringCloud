package com.example.eurekaconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * <p>
 *  声明本应用为Sping Cloud Eureka客户端，将注册到服务注册中心<br>
 *
 *  @EnableFeignClients :开启扫描Spring Cloud Feign客户端的功能
 *  </p>
 *
 * @author  zhuyong
 * @date    2018/10/8 9:44
 * @version V1.0.0
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class EurekaConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaConsumerApplication.class, args);
	}
}
