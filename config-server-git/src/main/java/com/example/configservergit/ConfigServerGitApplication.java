package com.example.configservergit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 通过 @EnableConfigServer 注解声明本应用为Spring Cloud 配置服务器
 *
 * @author  zhuyong
 * @date    2018/10/8 13:56
 * @version V1.0.0
 */
@EnableConfigServer
@SpringBootApplication
public class ConfigServerGitApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerGitApplication.class, args);
	}
}
