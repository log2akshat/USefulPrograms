package com.samsung.pharmacy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.samsung.pharmacy.request.PharmacyRequest;

@Service
public class PharmacyConsumerServiceImpl implements PharmacyConsumerService {

	@Autowired
	PharmacyRequest pharmacyRequestData;

	@Override
	public String addPharmacyDetails(PharmacyRequest request) {
		String url = "http://localhost:5566/pharmacy/add/store/location";
		pharmacyRequestData.setLocation(request.getLocation());
		pharmacyRequestData.setContact(request.getContact());
		pharmacyRequestData.setPincode(request.getPincode());

		// Converting our Java object to HttpEntity: i.e. RequestBody
		HttpEntity<PharmacyRequest> body = new HttpEntity<PharmacyRequest>(pharmacyRequestData);
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.exchange(url, HttpMethod.POST, body, String.class).getBody();
	}
}