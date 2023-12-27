package com.samsung.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class ValueTestingController {

	@Value("Akshat Singh")
	String userName;

	@Value("${order.portal}")
	String portalName;

	@Value("${order.details}")
	List<String> orderDetails;

	@Value("#{${order.price}}")
	Map<String,Integer> prices;

	@Profile("dev")
	@Bean
	public String testDevMethod(@Value("Order:")String order, @Value("Prices are: ")String priceDetails) {
		String str1 = order;
		String str2 = "User: " + userName + " has ordered " + orderDetails + " from " + portalName;
		String str3 = priceDetails;
		System.out.println(str1 + "\n" + str2 + "\n\n" + str3 + "\n" + prices);
		return "Executed Dev Profile";
	}

	@Profile("sit")
	@Bean
	public String testSitMethod(@Value("Order:")String order, @Value("Prices are: ")String priceDetails) {
		String str1 = order;
		String str2 = "User: " + userName + " has ordered " + orderDetails + " from " + portalName;
		String str3 = priceDetails;
		System.out.println(str1 + "\n" + str2 + "\n\n" + str3 + "\n" + prices);
		return "Executed Sit Profile";
	}
}
