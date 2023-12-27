package com.samsung.response;

import org.springframework.stereotype.Component;

@Component
public class SamsungStoreResponse {

	private String storeLocation;
	private String contactNumber;
	private String email;
	private int pincode;
	private String city;

	public SamsungStoreResponse() {
		super();
	}

	public SamsungStoreResponse(String storeLocation, String contactNumber, String email, int pincode, String city) {
		super();
		this.storeLocation = storeLocation;
		this.contactNumber = contactNumber;
		this.email = email;
		this.pincode = pincode;
		this.city = city;
	}

	public String getStoreLocation() {
		return storeLocation;
	}

	public void setStoreLocation(String storeLocation) {
		this.storeLocation = storeLocation;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}
