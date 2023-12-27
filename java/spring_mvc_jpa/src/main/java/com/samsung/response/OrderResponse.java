package com.samsung.response;

import org.springframework.stereotype.Component;

@Component
public class OrderResponse {

	private String response;
	private int status;

	public OrderResponse() {
		super();
	}

	public OrderResponse(String response, int status) {
		super();
		this.response = response;
		this.status = status;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
