package com.samsung.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.samsung.entity.OrderDetailsEntity;
import com.samsung.repository.OrderDetailsRepository;
import com.samsung.request.OrderDetailsRequest;
import com.samsung.request.OrderDetailsUpdateRequest;
import com.samsung.response.OrderResponse;

@Service
//@Transactional
public class OrderServiceImpl implements OrderService {

	Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

	@Autowired
	OrderDetailsEntity orderEntity;

	@Autowired
	OrderDetailsRepository repository;

	@Autowired
	OrderResponse response;
	
	@Override
	public OrderResponse addOrderDetails(OrderDetailsRequest request) {
		logger.info("Request Data at Service Layer: " + request);
		orderEntity.setOrderId(null);
		orderEntity.setCustomerName(request.getCustomerName());
		orderEntity.setProductName(request.getProductName());
		orderEntity.setStoreName(request.getStoreName());
		orderEntity.setCity(request.getCity());
		repository.save(orderEntity);
		response.setResponse("Order added successfully..");
		response.setStatus(201);
		return response;
	}

	@Override
	public String updateOrderDetails(Integer orderId, OrderDetailsUpdateRequest request) {
		logger.info("Request Data at Service Layer: " + request);
		repository.updateOrderDetails(orderId, request.getProductName());
		return "Updated product details successfully..";
	}

}
