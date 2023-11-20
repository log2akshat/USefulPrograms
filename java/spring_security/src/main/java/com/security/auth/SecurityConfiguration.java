package com.security.auth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfiguration {

	Logger logger = LoggerFactory.getLogger(SecurityConfiguration.class);

	@Autowired
	JWTTokenFilter jwtTokenFilter;

	@Bean
	BCryptPasswordEncoder getBCryptPasswordEncoder() {
		logger.info("Encoding the user provided password..");
		return new BCryptPasswordEncoder();
	}

	@Bean
	AuthenticationManager getAuthenticationManager
	(AuthenticationConfiguration authConfig)throws Exception {
		logger.info("Initializing Authentication Manager..");
		return authConfig.getAuthenticationManager();
	}

	@Bean
	SecurityFilterChain getSecurityFilterChain(HttpSecurity security) throws Exception {
		security.csrf(csrf -> csrf.disable())
				.cors(cors -> cors.disable())
				.authorizeHttpRequests(
						auth -> auth.requestMatchers("/user/login", "/user/register")
									.permitAll()
									.anyRequest()
									.authenticated()
						).addFilterBefore(this.jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
		return security.build();
	}
}
