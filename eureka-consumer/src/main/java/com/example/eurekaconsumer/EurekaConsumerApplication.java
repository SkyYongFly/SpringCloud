package com.example.eurekaconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 *  声明本应用为Sping Cloud Eureka客户端，将注册到服务注册中心
 *
 * @author  zhuyong
 * @date    2018/10/8 9:44
 * @version V1.0.0
 */
@EnableDiscoveryClient
@SpringBootApplication
public class EurekaConsumerApplication {

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(EurekaConsumerApplication.class, args);
	}
}
