package com.samsung.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class ProfileTestingController {

	@Value("Akshat Singh")
	String userName;

	@Value("${order.portal}")
	String portalName;

	@Value("${order.details}")
	List<String> orderDetails;

	@Value("#{${order.price}}")
	Map<String,Integer> prices;

	@GetMapping("/values")
	public String testMethod(@Value("Order:")String order, @Value("Prices are: ")String priceDetails) {
		String str1 = order;
		String str2 = "User: " + userName + " has ordered " + orderDetails + " from " + portalName;
		String str3 = priceDetails;
		return str1 + "\n" + str2 + "\n\n" + str3 + "\n" + prices;
	}
}
