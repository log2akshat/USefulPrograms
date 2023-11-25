package com.ms.user.consume.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ms.user.response.OrderRegisterResponse;

//ServiceID of the Producer
@FeignClient("order-service")
public interface OrderMicroserviceFeignClient {

	@GetMapping("/order/orderid/{orderId}")
	public ResponseEntity<OrderRegisterResponse> getUser(@PathVariable String orderId);

}
