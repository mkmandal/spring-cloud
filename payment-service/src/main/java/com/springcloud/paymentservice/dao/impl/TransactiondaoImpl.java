package com.springcloud.paymentservice.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcloud.paymentservice.dao.Transactiondao;
import com.springcloud.paymentservice.dto.TransactionRequest;
import com.springcloud.paymentservice.model.TransactionDetails;
import com.springcloud.paymentservice.repository.TransactionRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class TransactiondaoImpl implements Transactiondao {
	
	@Autowired
	TransactionRepository transactionRepository;

	@Override
	public long saveTransactionDetail(TransactionDetails detail) {
		// TODO Auto-generated method stub
		
		log.info("Recording payment detail {}",detail);
		return transactionRepository.save(detail).getId();
	}

	@Override
	public TransactionRequest getTransactionDetail(long orderId) {
		// TODO Auto-generated method stub
		return transactionRepository.findByOrderId(orderId);
	}

}
