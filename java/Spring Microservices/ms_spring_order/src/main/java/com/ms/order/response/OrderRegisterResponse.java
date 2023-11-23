package com.ms.order.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderRegisterResponse {

	private String userName;
	private String productName;
	private String email;
	private int productQuantity;
	private String city;
}
