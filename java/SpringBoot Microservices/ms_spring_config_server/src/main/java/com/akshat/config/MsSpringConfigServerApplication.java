package com.akshat.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class MsSpringConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsSpringConfigServerApplication.class, args);
	}

}
