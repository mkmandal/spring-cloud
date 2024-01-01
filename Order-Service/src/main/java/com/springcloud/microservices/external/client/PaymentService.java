package com.springcloud.microservices.external.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.springcloud.microservices.external.client.PaymentRequest.PaymentRequest;

@FeignClient(name="PAYMENT-SERVICE/transaction")
public interface PaymentService {
	
	@PostMapping("/saveTransactionDetail")
	public String saveTransactionDetail(@RequestBody PaymentRequest request);

}
