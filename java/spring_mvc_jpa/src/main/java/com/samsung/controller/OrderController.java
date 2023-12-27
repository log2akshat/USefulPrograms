package com.samsung.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.samsung.request.OrderDetailsRequest;
import com.samsung.request.OrderDetailsUpdateRequest;
import com.samsung.response.OrderResponse;
import com.samsung.service.OrderService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/order")
@CrossOrigin
public class OrderController {

	Logger logger = LoggerFactory.getLogger(OrderController.class);

	@Autowired
	OrderService orderService;

	@PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OrderResponse> addOrderDetails(@Valid @RequestBody OrderDetailsRequest request) {
		logger.info("Incoming request at controller: " + request);
		return new ResponseEntity<OrderResponse>(orderService.addOrderDetails(request), HttpStatus.CREATED);
	}

	@PutMapping(value = "/update/product/{orderId}")
	@ResponseStatus(value = HttpStatus.OK)
	public String updateOrderDetails(@PathVariable String orderId, @Valid @RequestBody OrderDetailsUpdateRequest request) {
		return orderService.updateOrderDetails(Integer.valueOf(orderId), request);
	}
}
