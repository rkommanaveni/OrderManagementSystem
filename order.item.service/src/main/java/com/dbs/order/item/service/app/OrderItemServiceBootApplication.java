package com.dbs.order.item.service.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OrderItemServiceBootApplication {
	
	private static final Logger log=LoggerFactory.getLogger(OrderItemServiceBootApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(OrderItemServiceBootApplication.class, args);
		
		log.info("Simple log statement with inputs {}, {} and {}", 1, 2, 3);
	}

}
