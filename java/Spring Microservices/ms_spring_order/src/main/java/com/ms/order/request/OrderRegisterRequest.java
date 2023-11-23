package com.ms.order.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRegisterRequest {

	private String userName;
	private String productName;
	private String email;
	private int productQuantity;
	private String city;
}
