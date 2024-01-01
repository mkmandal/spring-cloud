 package com.springcloud.paymentservice.service.impl;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcloud.paymentservice.dao.Transactiondao;
import com.springcloud.paymentservice.dto.TransactionRequest;
import com.springcloud.paymentservice.model.TransactionDetails;
import com.springcloud.paymentservice.service.TransactionService;


@Service
public class TransactionServiceImpl implements TransactionService  {
	
	@Autowired
	Transactiondao transactionDao;

	@Override
	public long saveTransactionDetail(TransactionRequest detail) {
		
		//TransactionDetails transactionDetail = new TransactionDetails();
		
		TransactionDetails transactionDetails
        = TransactionDetails.builder()
        .paymentDate(Instant.now())
        .paymentMode(detail.getPaymentMode().name())
        .paymentStatus("SUCCESS")
        .orderId(detail.getOrderId())
        .referenceNumber(detail.getReferenceNumber())
        .amount(detail.getAmount())
        .build();
		
		return transactionDao.saveTransactionDetail(transactionDetails);
	}

	@Override
	public TransactionRequest getTransationDetailByOrderId(long orderId) {
		
		TransactionRequest tra=transactionDao.getTransactionDetail(orderId);
		
		return tra;
	}

}
