package com.security.auth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SecurityConfiguration {

	Logger logger = LoggerFactory.getLogger(SecurityConfiguration.class);

	@Bean
	BCryptPasswordEncoder getBCryptPasswordEncoder() {
		logger.info("Encoding the user provided password..");
		return new BCryptPasswordEncoder();
	}
}
