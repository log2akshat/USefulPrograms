package com.samsung.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samsung.entity.SamsungStoreEntity;
import com.samsung.repository.SamsungStoreRepository;
import com.samsung.request.SamsungStoreRequest;
import com.samsung.response.SamsungStoreResponse;

@Service
public class SamsungStoreService {

	Logger logger = LoggerFactory.getLogger(SamsungStoreService.class);

	@Autowired
	SamsungStoreRepository repository;

	@Autowired
	SamsungStoreEntity storeEntity;

	@Autowired
	SamsungStoreResponse response;

	public String addStoreDetails(SamsungStoreRequest request) {
		logger.info("Request Data at Service Layer: " + request);
		storeEntity.setStoreLocation(request.getStoreLocation());
		storeEntity.setContactNumber(request.getContactNumber());
		storeEntity.setEmail(request.getEmail());
		storeEntity.setPincode(request.getPincode());
		storeEntity.setCity(request.getCity());
		repository.save(storeEntity);
		return "Details added successfully";
	}

	public SamsungStoreResponse getStoreLocation(SamsungStoreRequest request) {
		Optional<SamsungStoreEntity> storeLocation = repository.findById(request.getContactNumber());
		if(storeLocation.isPresent()) {
			SamsungStoreEntity entity = storeLocation.get();
			response.setStoreLocation(entity.getStoreLocation());
			response.setContactNumber(entity.getContactNumber());
			response.setEmail(entity.getEmail());
			response.setPincode(entity.getPincode());
			response.setCity(entity.getCity());
		}
		return response;
	}

	public List<SamsungStoreResponse> getLocationDetailsBylocationName(SamsungStoreRequest request) {
		List<SamsungStoreEntity> data = repository.findByStoreLocation(request.getStoreLocation());
		List<SamsungStoreResponse> response = data.stream().map(l -> new SamsungStoreResponse(l.getStoreLocation(), 
				l.getContactNumber(), l.getEmail(), l.getPincode(), l.getCity()))
				.collect(Collectors.toList());
		return response;
	}

	// Older Java versions code
	public List<SamsungStoreResponse> loadLocationDetailsBylocationName(String locationName) {
	    List<SamsungStoreEntity> data = repository.findByStoreLocation(locationName);
	    List<SamsungStoreResponse> response = new ArrayList<>();

	    for (SamsungStoreEntity entity : data) {
	        SamsungStoreResponse storeResponse = new SamsungStoreResponse(entity.getStoreLocation(), 
	        		entity.getContactNumber(), entity.getEmail(), entity.getPincode(), entity.getCity());
	        response.add(storeResponse);
	    }
	    return response;
	}

	public List<SamsungStoreResponse> getStoreByPincodeOrCity(int pincode, String city) {
		List<SamsungStoreEntity> data = repository.findByPincodeOrCity(pincode, city);
		List<SamsungStoreResponse> response = data.stream().map(l -> new SamsungStoreResponse(l.getStoreLocation(),
				l.getContactNumber(), l.getEmail(), l.getPincode(), l.getCity())).collect(Collectors.toList());
		return response;
	}

	public List<SamsungStoreResponse> getStoreByPincodeAndCityNativeIndexedQuery(String city, int pincode) {
		List<SamsungStoreEntity> data = repository.getStoreByPincodeAndCityNativeIndexedQuery(city, pincode);
		List<SamsungStoreResponse> response = data.stream().map(l -> new SamsungStoreResponse(l.getStoreLocation(),
				l.getContactNumber(), l.getEmail(), l.getPincode(), l.getCity())).collect(Collectors.toList());
		return response;
	}

	public List<SamsungStoreResponse> getStoreByPincodeOrCityNativeNamedQuery(String city, int pincode) {
		List<SamsungStoreEntity> data = repository.getStoreByPincodeOrCityNativeNamedQuery(city, pincode);
		List<SamsungStoreResponse> response = data.stream().map(l -> new SamsungStoreResponse(l.getStoreLocation(),
				l.getContactNumber(), l.getEmail(), l.getPincode(), l.getCity())).collect(Collectors.toList());
		return response;
	}

	public List<SamsungStoreResponse> getStoreByCityJPQLQuery(String city) {
		List<SamsungStoreEntity> data = repository.getStoreByCityJPQLQuery(city);
		List<SamsungStoreResponse> response = data.stream().map(l -> new SamsungStoreResponse(l.getStoreLocation(),
				l.getContactNumber(), l.getEmail(), l.getPincode(), l.getCity())).collect(Collectors.toList());
		return response;
	}
}
