package com.samsung.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class OrderDetailsUpdateRequest {

	@NotNull(message = "Product name should not be null")
	@NotEmpty(message = "Product name should not be empty")
	private String productName;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
}
