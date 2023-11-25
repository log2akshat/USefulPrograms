package com.ms.gateway.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MsSpringGatewayEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsSpringGatewayEurekaApplication.class, args);
	}

}
