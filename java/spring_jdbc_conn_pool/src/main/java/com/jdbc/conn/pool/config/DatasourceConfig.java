package com.jdbc.conn.pool.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class DatasourceConfig {

	@Value("${spring.datasource.url}")
	String url;

	@Value("${spring.datasource.username}")
	String username;

	@Value("${spring.datasource.password}")
	String password;

	
	  @Bean DataSource datasource() { 
	  // DriverManagerDataSource: FOR TESTING ONLY -> Doesn't provide any Connection Pooling 
	  // DriverManagerDataSource datasource = new DriverManagerDataSource();
	  // datasource.setUrl(url);
	  HikariDataSource datasource = new HikariDataSource();
	  datasource.setPoolName("akshat-connection-pool");
	  datasource.setJdbcUrl(url);
	  datasource.setUsername(username);
	  datasource.setPassword(password); 
	  return datasource;
	  }
	 

	// Uncomment if you wish to use c3p0 Connection Pooling
	/*
	 * @Bean
	DataSource datasource() {
		ComboPooledDataSource datasource = new ComboPooledDataSource();
		datasource.setJdbcUrl(url);
		datasource.setUser(username);
		datasource.setPassword(password); 
		return datasource;
	}
	*/


	@Bean
	JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(datasource());
	}
}
