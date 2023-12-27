package com.samsung.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Component
@Entity
@Table(name = "SAMSUNG_STORE")
public class SamsungStoreEntity {

	@Column(name = "STORE_LOCATION")
	private String storeLocation;

	@Column(name="CONTACT_NUMBER")
	private String contactNumber;

	@Id
	@Column(name = "EmailID")
	private String email;

	@Column(name="PINCODE")
	private int pincode;

	@Column(name = "CITY")
	private String city;

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
