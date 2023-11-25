package com.ms.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MsSpringOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsSpringOrderApplication.class, args);
	}

}
