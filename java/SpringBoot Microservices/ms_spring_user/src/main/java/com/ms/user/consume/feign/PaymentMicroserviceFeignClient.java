package com.ms.user.consume.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ms.user.request.PaymentRequest;

// ServiceID of the Producer
@FeignClient("payment-service")
public interface PaymentMicroserviceFeignClient {

	@PostMapping("/payment/make")
	public Integer makePayment(@RequestBody PaymentRequest request);

}
