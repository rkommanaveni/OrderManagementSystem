package com.dbs.orderservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("com.dbs.orderservice.proxy")
public class OrderServiceBootApplication {
	private static final Logger log = LoggerFactory.getLogger(OrderServiceBootApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceBootApplication.class, args);

		log.info("Simple log statement with inputs {}, {} and {}", 1, 2, 3);
	}

}
