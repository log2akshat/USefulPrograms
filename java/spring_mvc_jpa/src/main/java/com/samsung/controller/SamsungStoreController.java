package com.samsung.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.samsung.request.SamsungStoreRequest;
import com.samsung.response.SamsungStoreResponse;
import com.samsung.service.SamsungStoreService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/store")
public class SamsungStoreController {

	Logger logger = LoggerFactory.getLogger(SamsungStoreController.class);
	
	@Autowired
	SamsungStoreService samsungStoreService;
	
	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public String saveStoreData(@Valid @RequestBody SamsungStoreRequest request) {
		return samsungStoreService.addStoreDetails(request);
	}

	@GetMapping("/load")
	public SamsungStoreResponse loadStoreLocation(@RequestBody SamsungStoreRequest request) {
		SamsungStoreResponse storeLocation = samsungStoreService.getStoreLocation(request);
		return storeLocation;
	}

	@GetMapping("/load/location")
	public List<SamsungStoreResponse> getLocationDetailsByLocationName(@RequestBody SamsungStoreRequest request) {
		List<SamsungStoreResponse> response = samsungStoreService.getLocationDetailsBylocationName(request);
		return response;
	}

	// Path Variables
	@GetMapping("/load/location/{storeLocation}")
	public List<SamsungStoreResponse> getLocationDetailsByLocationName(@PathVariable(name = "storeLocation") String storeLocation) {
		List<SamsungStoreResponse> response = samsungStoreService.loadLocationDetailsBylocationName(storeLocation);
		return response;
	}

	// Query/Request Params
	@GetMapping("/pincode/city")
	public List<SamsungStoreResponse> getStoreByPincodeOrCity(@RequestParam String pincode, @RequestParam(required = false) String city) {
		List<SamsungStoreResponse> response = samsungStoreService.getStoreByPincodeOrCity(Integer.parseInt(pincode), city);
		return response;
	}

	// Native SQl Queries : Get data based on city and pincode
	@GetMapping("/city/{city}/pincode/{pincode}")
	public List<SamsungStoreResponse> getStoreByPincodeAndCityNativeIndexedQuery(@PathVariable String city, @PathVariable String pincode) {
		List<SamsungStoreResponse> response = samsungStoreService.getStoreByPincodeAndCityNativeIndexedQuery(city, Integer.parseInt(pincode));
		return response;
	}

	@GetMapping("/city/pincode")
	public List<SamsungStoreResponse> getStoreByPincodeOrCityNativeNamedQuery(@RequestParam String city, @RequestParam String pincode) {
		List<SamsungStoreResponse> response = samsungStoreService.getStoreByPincodeOrCityNativeNamedQuery(city, Integer.parseInt(pincode));
		return response;
	}

	// JPQL Query
	@GetMapping("/city")
	public ResponseEntity<List<SamsungStoreResponse>> getStoreByCityJPQLQuery(@RequestParam String city) {
		List<SamsungStoreResponse> response = samsungStoreService.getStoreByCityJPQLQuery(city);
		logger.info("City name passed from controler layer: " + city);
		if (response.size() != 0) {
			return new ResponseEntity<List<SamsungStoreResponse>>(response, HttpStatus.OK);
		}
		return new ResponseEntity<List<SamsungStoreResponse>>(response, HttpStatus.NOT_FOUND);
	}
}
