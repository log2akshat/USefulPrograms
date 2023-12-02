package com.jdbc.conn.pool;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication(exclude = {
		JdbcTemplateAutoConfiguration.class,
		DataSourceAutoConfiguration.class
})
public class SpringJdbcConnPoolApplication implements CommandLineRunner {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcConnPoolApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		jdbcTemplate.update("INSERT INTO order_details(customer_name, product_name, store_name, city) VALUES('Pratap Singh', 'Sword', 'Mahal', 'Chittorgarh')");
		
		List<Map<String, Object>> queryMap = 
				jdbcTemplate.queryForList("SELECT * FROM order_details");
		queryMap.forEach(item -> {
				System.out.println("Order Id: " + item.get("order_id"));
				System.out.println("Customer Name: " + item.get("customer_name"));
				System.out.println("Product Name: " + item.get("product_name"));
				System.out.println("Store Name: " + item.get("store_name"));
				System.out.println("City Name: " + item.get("city"));
				System.out.println("---------------------------------------------");
		});
	}

}
