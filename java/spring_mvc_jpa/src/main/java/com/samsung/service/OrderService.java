package com.samsung.service;

import com.samsung.request.OrderDetailsRequest;
import com.samsung.request.OrderDetailsUpdateRequest;
import com.samsung.response.OrderResponse;

public interface OrderService {

	OrderResponse addOrderDetails(OrderDetailsRequest request);

	String updateOrderDetails(Integer integer, OrderDetailsUpdateRequest request);

}
