package com.ms.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ms.payment.request.PaymentRequest;
import com.ms.payment.service.PaymentService;

@RestController
public class PaymentController {

	@Autowired
	PaymentService service;

	@PostMapping("/make")
	public Integer makePayment(@RequestBody PaymentRequest request) {
		return service.makePayment(request);
	}
}
