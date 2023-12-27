package com.samsung.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class OrderDetailsRequest {

	private Integer orderId;
	
	@NotNull(message = "Customer name should not be null")
	@NotEmpty(message = "Customer name should not be empty")
	private String customerName;
	
	@NotNull(message = "Product name should not be null")
	@NotEmpty(message = "Product name should not be empty")
	private String productName;

	@NotNull(message = "Store name should not be null")
	@NotEmpty(message = "Store name should not be empty")
	private String storeName;
	private String city;

	public OrderDetailsRequest() {
		super();
	}

	public OrderDetailsRequest(Integer orderId, String customerName, String productName, String storeName, String city) {
		super();
		this.orderId = orderId;
		this.customerName = customerName;
		this.productName = productName;
		this.storeName = storeName;
		this.city = city;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "OrderDetailsRequest [orderId=" + orderId + ", customerName=" + customerName + ", productName="
				+ productName + ", storeName=" + storeName + ", city=" + city + "]";
	}
}
