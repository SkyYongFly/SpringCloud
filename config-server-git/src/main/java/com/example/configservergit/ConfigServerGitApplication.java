package com.example.configservergit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * <p>
 * 	通过 @EnableConfigServer 注解声明本应用为Spring Cloud 配置服务器<br>
 * 	同时通过@EnableDiscoveryClient将应用注册到服务注册中心，方便后续构建配置服务器集群，实现高可用
 * </p>
 *
 * @author  zhuyong
 * @date    2018/10/8 13:56
 * @version V1.0.0
 */
@EnableConfigServer
@EnableDiscoveryClient
@SpringBootApplication
public class ConfigServerGitApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerGitApplication.class, args);
	}
}
