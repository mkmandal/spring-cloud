package com.springcloud.paymentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.paymentservice.dto.TransactionRequest;
import com.springcloud.paymentservice.service.TransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
	
	
	@Autowired
	private TransactionService transactionService;

	
	@PostMapping("/saveTransactionDetail")
	public String saveTransactionDetail(@RequestBody TransactionRequest request) {
		
		transactionService.saveTransactionDetail(request);
		
		return "Success";
	}
	
	@GetMapping("/getPaymentDtail/{orderId}")
	public String getTransactionDetail(@PathVariable long orderId) {
		
	   TransactionRequest trans=transactionService.getTransationDetailByOrderId(orderId);
		
		return "Success";
	}
	
}
