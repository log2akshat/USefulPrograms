package com.ms.payment.service;

import com.ms.payment.request.PaymentRequest;

public interface PaymentService {

	Integer makePayment(PaymentRequest request);

}
