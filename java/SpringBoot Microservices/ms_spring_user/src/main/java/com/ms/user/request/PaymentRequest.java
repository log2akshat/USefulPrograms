package com.ms.user.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentRequest {

	private String email;
	private int orderId;
	private double amountPaid;
	private String paymentStatus;
}
