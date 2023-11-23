package com.ms.order.service;

import com.ms.order.request.OrderRegisterRequest;
import com.ms.order.response.OrderRegisterResponse;

public interface OrderService {

	public String registerOrder(OrderRegisterRequest request);

	public OrderRegisterResponse getOrder(String orderId);

}
