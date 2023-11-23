package com.ms.order.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ms.order.entity.OrderRegisterEntity;
import com.ms.order.repository.OrderRepository;
import com.ms.order.request.OrderRegisterRequest;
import com.ms.order.response.OrderRegisterResponse;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository repository;

	@Override
	public String registerOrder(OrderRegisterRequest request) {
		OrderRegisterEntity entity =
				OrderRegisterEntity.builder()
				.userName(request.getUserName())
				.productName(request.getProductName())
				.email(request.getEmail())
				.productQuantity(request.getProductQuantity())
				.city(request.getCity())
				.build();
		repository.save(entity);
		return "Order details added successfully..";
	}

	@Override
	public OrderRegisterResponse getOrder(String orderId) {
		Optional<OrderRegisterEntity> entity = repository.findById(Integer.parseInt(orderId));
		OrderRegisterResponse orderResponse = null;
		if(entity.isPresent()) {
			OrderRegisterEntity entityResponse = entity.get();
			orderResponse = OrderRegisterResponse.builder()
					.userName(entityResponse.getUserName())
					.productName(entityResponse.getProductName())
					.email(entityResponse.getEmail())
					.productQuantity(entityResponse.getProductQuantity())
					.city(entityResponse.getCity())
					.build();
		}
		return orderResponse;
	}

}
