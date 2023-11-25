package com.ms.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MsSpringUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsSpringUserApplication.class, args);
	}

}
