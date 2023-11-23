package com.ms.payment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.payment.entity.PaymentEntity;
import com.ms.payment.repository.PaymentRepository;
import com.ms.payment.request.PaymentRequest;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	PaymentRepository repository;

	@Override
	public Integer makePayment(PaymentRequest request) {
		PaymentEntity entity = PaymentEntity.builder()
				.email(request.getEmail())
				.orderId(request.getOrderId())
				.amountPaid(request.getAmountPaid())
				.paymentStatus(request.getPaymentStatus())
				.build();
		repository.save(entity);
		return entity.getPaymentId();
	}

}
