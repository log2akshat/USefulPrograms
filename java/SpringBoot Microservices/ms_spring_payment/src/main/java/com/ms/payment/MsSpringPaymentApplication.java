package com.ms.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MsSpringPaymentApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsSpringPaymentApplication.class, args);
	}

}
