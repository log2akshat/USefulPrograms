package com.ms.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ms.order.request.OrderRegisterRequest;
import com.ms.order.response.OrderRegisterResponse;
import com.ms.order.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	OrderService service;

	@PostMapping("/register")
	public String registerOrder(@RequestBody OrderRegisterRequest request) {
		return service.registerOrder(request);
	}

	@GetMapping("/orderid/{orderId}")
	public ResponseEntity<OrderRegisterResponse> getUser(@PathVariable String orderId) {
		OrderRegisterResponse response = service.getOrder(orderId);
		if (response != null) {
			return new ResponseEntity<OrderRegisterResponse>(response, HttpStatus.OK);
		}
		return new ResponseEntity<OrderRegisterResponse>(response, HttpStatus.NOT_FOUND);
	}
}
