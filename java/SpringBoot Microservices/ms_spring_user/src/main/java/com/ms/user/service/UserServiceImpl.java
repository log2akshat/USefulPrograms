package com.ms.user.service;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ms.user.consume.feign.OrderMicroserviceFeignClient;
import com.ms.user.consume.feign.PaymentMicroserviceFeignClient;
import com.ms.user.controller.UserController;
import com.ms.user.entity.UserRegisterEntity;
import com.ms.user.repository.UserRepository;
import com.ms.user.request.PaymentRequest;
import com.ms.user.request.UserRegisterRequest;
import com.ms.user.response.OrderRegisterResponse;
import com.ms.user.response.UserRegisterResponse;

@Service
public class UserServiceImpl implements UserService {

	Logger logger = LogManager.getLogger(UserController.class);

	@Autowired
	UserRepository repository;

	@Autowired
	PaymentMicroserviceFeignClient paymentClient;

	@Autowired
	OrderMicroserviceFeignClient orderClient;

	@Override
	public String registerUser(UserRegisterRequest request) {
		UserRegisterEntity entity =
				UserRegisterEntity.builder()
				.name(request.getName())
				.email(request.getEmail())
				.mobile(request.getMobile())
				.city(request.getCity())
				.build();
		repository.save(entity);
		logger.info("User details added successfully.");
		return "User details added successfully..";
	}

	@Override
	public UserRegisterResponse getUser(String userId) {
		Optional<UserRegisterEntity> entity = repository.findById(Integer.parseInt(userId));
		UserRegisterResponse userResponse = null;
		if(entity.isPresent()) {
			UserRegisterEntity entityResponse = entity.get();
			userResponse = UserRegisterResponse.builder()
					.name(entityResponse.getName())
					.email(entityResponse.getEmail())
					.mobile(entityResponse.getMobile())
					.city(entityResponse.getCity())
					.build();
		}
		logger.info("Got the user response from repository: " + userResponse);
		return userResponse;
	}

	@Override
	public Integer makePayment(PaymentRequest request) {
		logger.info("Connecting to payment-service for making the payment.");
		return paymentClient.makePayment(request);
	}

	@Override
	public ResponseEntity<OrderRegisterResponse> getOrderServiceUser(String orderId) {
		logger.info("Connecting to order-service for getting the user details of the provided orderId: " + orderId);
		return orderClient.getUser(orderId);
	}

}
