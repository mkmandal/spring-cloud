package com.springcloud.paymentservice.service;

import com.springcloud.paymentservice.dto.TransactionRequest;
import com.springcloud.paymentservice.model.TransactionDetails;

public interface TransactionService {
	
	long saveTransactionDetail(TransactionRequest request);

	TransactionRequest getTransationDetailByOrderId(long orderId);

}
