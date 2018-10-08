package com.example.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @EnableDiscoveryClient 将配置客户端注册到服务注册中心
 */
@EnableDiscoveryClient
@SpringBootApplication
@RestController
public class ConfigClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class, args);
	}

	/**
	 * 这里通过占位符获取远程配置文件中的配置信息
	 */
	@Value("${user}")
	String user;

	/**
	 * 通过访问  http://localhost:2402/user  可以获取user配置值
	 * 其实不设置MVC的话也可以直接访问属性值，例如 http://localhost:2402/info 会直接解析映射对应的 info节点的配置值
	 * @return
     */
	@GetMapping("/user")
	public String getConfigUserNode(){
		return user;
	}
}
