package com.example.eurekaconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 *  声明本应用为Sping Cloud Eureka客户端，将注册到服务注册中心
 *  @EnableCircuitBreaker 开启服务降级功能
 *
 * @author  zhuyong
 * @date    2018/10/8 16:18
 * @version V1.0.0
 */
@EnableCircuitBreaker
@EnableDiscoveryClient
@SpringBootApplication
public class EurekaConsumerApplication {

	/**
	 * REST请求实体bean, @LoadBalanced 实现客户端负载均衡功能
	 *
	 * @return
     */
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(EurekaConsumerApplication.class, args);
	}
}
