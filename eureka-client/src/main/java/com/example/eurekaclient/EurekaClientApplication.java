package com.example.eurekaclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 *  声明本应用为Sping Cloud Eureka客户端，将注册到服务注册中心
 *
 * @author  zhuyong
 * @date    2018/10/8 9:29
 * @version V1.0.0
 */
@EnableDiscoveryClient
@SpringBootApplication
public class EurekaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientApplication.class, args);
	}
}
