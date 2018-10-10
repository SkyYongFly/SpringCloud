package com.example.trace;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class Trace1Application {
	private final Logger logger = Logger.getLogger(Trace1Application.class);

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

	@GetMapping("/service-1")
	public String trace(){
		logger.info("=== Trace1被调用了===");
		return restTemplate().getForEntity("http://trace-2/service-2", String.class).getBody();
	}

	public static void main(String[] args) {
		SpringApplication.run(Trace1Application.class, args);
	}
}
