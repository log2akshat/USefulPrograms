package com.ms.user.service;

import org.springframework.http.ResponseEntity;

import com.ms.user.request.PaymentRequest;
import com.ms.user.request.UserRegisterRequest;
import com.ms.user.response.OrderRegisterResponse;
import com.ms.user.response.UserRegisterResponse;

public interface UserService {

	public String registerUser(UserRegisterRequest request);

	public UserRegisterResponse getUser(String userId);

	public Integer makePayment(PaymentRequest request);

	public ResponseEntity<OrderRegisterResponse> getOrderServiceUser(String orderId);

}
