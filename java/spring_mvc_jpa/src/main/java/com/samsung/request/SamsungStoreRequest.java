package com.samsung.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class SamsungStoreRequest {
	
	private String storeLocation;
	private String contactNumber;

	@JsonProperty("E-mailID")
	@NotNull(message = "E-mail ID name should not be null")
	@NotEmpty(message = "E-mail ID name should not be empty")
	@Email(message = "E-mail ID is not valid")
	private String email;

	private int pincode;
	private String city;

	public SamsungStoreRequest() {
		super();
	}

	public SamsungStoreRequest(String storeLocation, String contactNumber, String email, int pincode, String city) {
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

	@Override
	public String toString() {
		return "SamsungStoreRequest [storeLocation=" + storeLocation + ", contactNumber=" + contactNumber + ", email="
				+ email + ", pincode=" + pincode + ", city=" + city + "]";
	}
}
