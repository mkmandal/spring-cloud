package com.springcloud.paymentservice.dao;

import com.springcloud.paymentservice.dto.TransactionRequest;
import com.springcloud.paymentservice.model.TransactionDetails;

public interface Transactiondao {

	long saveTransactionDetail(TransactionDetails detail);

	TransactionRequest getTransactionDetail(long orderId);

}
