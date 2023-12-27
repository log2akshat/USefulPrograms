package com.samsung.pharmacy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.samsung.pharmacy.request.PharmacyRequest;
import com.samsung.pharmacy.service.PharmacyConsumerService;

@RestController
@RequestMapping("/pharmacy")
public class PharmacyConsumerController {

	@Autowired
	PharmacyConsumerService pharmacyService;
	
	@PostMapping("/add/location")
	public String addPharmacyDetails(@RequestBody PharmacyRequest request) {
		return pharmacyService.addPharmacyDetails(request);
	}
}
